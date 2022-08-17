package com.KoreaIt.example.JAM.dao;

import java.sql.Connection;
import java.util.Map;

import com.KoreaIt.example.JAM.Member;
import com.KoreaIt.example.JAM.util.DBUtil;
import com.KoreaIt.example.JAM.util.SecSql;

public class MemberDao {
	private Connection conn;

	public MemberDao(Connection conn) {
		this.conn = conn;
	}

	public boolean isLoginIdDup(String loginId) {
		SecSql sql = new SecSql();

		sql.append("SELECT COUNT(*) > 0");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?", loginId);

		return DBUtil.selectRowBooleanValue(conn, sql);
	}

	public int doJoin(String loginId, String loginPw, String name) {
		SecSql sql = new SecSql();

		sql.append("INSERT INTO `member`");
		sql.append(" SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", loginId = ?", loginId);
		sql.append(", loginPw = ?", loginPw);
		sql.append(", name = ?", name);

		int id = DBUtil.insert(conn, sql);

		return id;
	}

	public Member getMemberByLoginId(String loginId) {
		SecSql sql = new SecSql();

		sql.append("SELECT*FROM `member` ");
		sql.append("WHERE loginId=?", loginId);
		
		Map<String, Object> member =DBUtil.selectRow(conn, sql);
		
		if(member.isEmpty()) {
			return null;
		}
		return new Member(member);
	}

}
