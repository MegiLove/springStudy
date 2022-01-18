package com.sist.exam07;

public class WriteArticleServiceImpl {
	private ArticleDao dao;

	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}
	
	public void insert() {
		dao.insert();
	}
}
