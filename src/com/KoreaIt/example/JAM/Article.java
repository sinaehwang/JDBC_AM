package com.KoreaIt.example.JAM;

import java.time.LocalDateTime;
import java.util.Map;

public class Article extends Object {

	public int id;
	public LocalDateTime regDate;
	public LocalDateTime updateDate;
	public String title;
	public String body;
	public int memberId;
	
	public String extra__writer;


	/*
	 * public Article(int id, LocalDateTime regDate, LocalDateTime updateDate,
	 * String title, String body) { this.id = id; this.regDate = regDate;
	 * this.updateDate = updateDate; this.title = title; this.body = body; }
	 */
	


	public Article(Map<String, Object> articleMap) {
		this.id = (int) articleMap.get("id");
		this.regDate = (LocalDateTime) articleMap.get("regDate");
		this.updateDate = (LocalDateTime) articleMap.get("updateDate");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");
		this.memberId = (int) articleMap.get("memberId");

		if(articleMap.get("extra__writer")!=null) {
			
			this.extra__writer = (String) articleMap.get("extra__writer");
		}
		
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", title=" + title
				+ ", body=" + body + ", memberId=" + memberId + "]";
	}
	
	



}