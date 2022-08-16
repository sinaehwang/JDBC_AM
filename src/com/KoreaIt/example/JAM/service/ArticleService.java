package com.KoreaIt.example.JAM.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.KoreaIt.example.JAM.Article;
import com.KoreaIt.example.JAM.dao.ArticleDao;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService(Connection conn) {
		articleDao = new ArticleDao(conn);
	}

	public int doWrite(String title, String body) {

		return articleDao.doWrite(title, body);
	}

	public boolean isArticleExists(int id) {
		return articleDao.isArticleExists(id);
	}

	public void doDelete(int id) {
		articleDao.doDelete(id);
	}

	public Map<String, Object> selectRow(int id) {
		
		return articleDao.selectRow(id);
	}

	public void doUpdate(int id, String title, String body) {
		articleDao.doUpdate(id,title,body);
		
	}

public List<Article> getArticles() {
		
		return articleDao.getArticles();
	}

}
