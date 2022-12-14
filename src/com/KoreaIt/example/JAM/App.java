package com.KoreaIt.example.JAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.KoreaIt.example.JAM.controller.ArticleController;
import com.KoreaIt.example.JAM.controller.MemberController;
import com.KoreaIt.example.container.Container;

public class App {

	public void run() {
		Container.sc = new Scanner(System.in);

		Container.init();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = Container.sc.nextLine().trim();

			// DB 연결
			Connection conn = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");

			} catch (ClassNotFoundException e) {
				System.out.println("예외 : 클래스가 없습니다.");
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			String url = "jdbc:mysql://127.0.0.1:3306/article_manager?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";

			try {
				conn = DriverManager.getConnection(url, "root", "");

				Container.conn = conn;

				int actionResult = action(cmd);

				if (actionResult == -1) {
					break;
				}

			} catch (SQLException e) {
				System.out.println("@@@@에러@@@@: " + e);
				break;
			} finally {
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private int action(String cmd) {

		if (cmd.equals("exit")) {
			System.out.println("프로그램을 종료합니다");
			return -1;
		}

		MemberController memberController = Container.memberController;
		ArticleController articleController = Container.articleController;

		if (cmd.equals("member join")) {
			memberController.doJoin(cmd);
		} else if (cmd.equals("member login")) {
			memberController.login(cmd);
		} else if (cmd.equals("member logout")) {
			memberController.logout(cmd);
		} else if (cmd.equals("member profile")) {
			memberController.showProfile(cmd);
		} else if (cmd.equals("article write")) {
			articleController.doWrite(cmd);
		} else if (cmd.startsWith("article delete ")) {
			articleController.doDelete(cmd);
		} else if (cmd.startsWith("article detail ")) {
			articleController.showDetail(cmd);
		} else if (cmd.startsWith("article modify ")) {
			articleController.doModify(cmd);
		} else if (cmd.startsWith("article list")) {
			articleController.showList(cmd);
		} else {
			System.out.println("존재하지 않는 명령어 입니다");
		}

		return 0;
	}

}