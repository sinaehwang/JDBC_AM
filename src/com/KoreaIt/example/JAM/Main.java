package com.KoreaIt.example.JAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Article>articles = new ArrayList<>();
		
		int lastArticleId=0;
		

		while (true) {

			System.out.print("명령어:");

			String cmd = sc.nextLine().trim();
			
			if (cmd.equals("exist")) {

				System.out.println("시스템을 종료합니다");

				break;

			}
			
			if (cmd.equals("article write")) {

				int id = lastArticleId+1;
				lastArticleId++;
				
				System.out.print("제목");
				String title = sc.nextLine();
				System.out.print("내용");
				String body = sc.nextLine();
				
				Article article = new Article(id,title,body);
				articles.add(article);
				
				System.out.printf("%d번글이생성되었습니다.\n",article.id);

				continue;
			}
			
			else if(cmd.equals("article list")) {
				System.out.println("===게시물리스트===");
				
				if(articles.size()==0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.println("번호|제목");
 				
				for(Article article : articles) {
					
					System.out.printf("%d|%s\n",article.id,article.title);
				}
			}
			
			else {
				System.out.println("존재하지않는명령어입니다.");
			}



		}
	}
}
