package com.KoreaIt.example.JAM;

import java.time.LocalDateTime;
import java.util.Map;

public class Member extends Object {
	public int id;
	public LocalDateTime regDate;
	public LocalDateTime updateDate;
	public String loginId;
	public String loginPw;
	public String name;

	public Member(Map<String, Object> member) {
		this.id = (int) member.get("id");
		this.regDate = (LocalDateTime) member.get("regDate");
		this.updateDate = (LocalDateTime) member.get("updateDate");
		this.loginId = (String) member.get("loginId");
		this.loginPw = (String) member.get("loginPw");
		this.name = (String) member.get("name");
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", loginId=" + loginId
				+ ", loginPw=" + loginPw + ", name=" + name + "]";
	}
	

}
