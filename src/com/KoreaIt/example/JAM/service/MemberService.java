package com.KoreaIt.example.JAM.service;

import java.sql.Connection;

import com.KoreaIt.example.JAM.Member;
import com.KoreaIt.example.JAM.dao.MemberDao;

public class MemberService {
	private MemberDao memberDao;

	public MemberService(Connection conn) {
		memberDao = new MemberDao(conn);
	}

	public boolean isLoginIdDup(String loginId) {
		return memberDao.isLoginIdDup(loginId);
	}

	public int doJoin(String loginId, String loginPw, String name) {
		return memberDao.doJoin(loginId, loginPw, name);
	}

	public Member getMemberByLoginId(String loginId) {
		
		return memberDao.getMemberByLoginId(loginId);
	}

}