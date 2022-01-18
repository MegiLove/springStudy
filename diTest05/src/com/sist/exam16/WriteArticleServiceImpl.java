package com.sist.exam16;

public class WriteArticleServiceImpl {
	private ArticleDao dao;

	
	
	public WriteArticleServiceImpl(ArticleDao dao) {
		super();
		this.dao = dao;
	}



	public void insert() {
		dao.insert();
	}
}
