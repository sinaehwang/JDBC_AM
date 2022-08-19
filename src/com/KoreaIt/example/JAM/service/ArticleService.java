package com.KoreaIt.example.JAM.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.KoreaIt.example.JAM.Article;
import com.KoreaIt.example.JAM.dao.ArticleDao;
import com.KoreaIt.example.container.Container;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int doWrite(int memberId, String title, String body) {

		return articleDao.doWrite(memberId, title, body);
	}

	public boolean isArticleExists(int id) {
		return articleDao.isArticleExists(id);
	}

	public void doDelete(int id) {
		articleDao.doDelete(id);
	}

	public Article getArticleById(int id) {

		return articleDao.getArticleById(id);
	}

	public void doUpdate(int id, String title, String body) {
		articleDao.doUpdate(id, title, body);

	}

	public List<Article> getArticles() {

		return articleDao.getArticles();
	}

	public List<Article> getForPrintArticles(int page, int itemsInAPage, String searchKeyword) {
		int limitFrom = (page - 1) * itemsInAPage;
		int limitTake = itemsInAPage;

		Map<String, Object> args = new HashMap<>();
		args.put("searchKeyword", searchKeyword);
		args.put("limitFrom", limitFrom);
		args.put("limitTake", limitTake);

		return articleDao.getForPrintArticles(args);
	}

	public void increaseHit(int id) {
		articleDao.increaseHit(id);
	}

}