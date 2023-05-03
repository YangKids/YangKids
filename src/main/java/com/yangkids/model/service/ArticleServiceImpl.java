package com.yangkids.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangkids.model.dao.ArticleDao;
import com.yangkids.model.dto.Article;
import com.yangkids.model.dto.SearchCondition;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;

	// Dao 인스턴스를 주입 해준다. (서7유지나)
	@Autowired
	public void setBoardDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public List<Article> getArticleList() {
		return articleDao.selectAll();
	}

	@Override
	public Article readArticle(int id) {
		articleDao.updateViewCnt(id);
		return articleDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeArticle(Article article) {
		articleDao.insertArticle(article);
	}

	@Transactional
	@Override
	public void removeArticle(int id) {
		articleDao.deleteArticle(id);
	}

	@Transactional
	@Override
	public void modifyArticle(Article article) {
		articleDao.updateArticle(article);
	}

	@Override
	public List<Article> search(SearchCondition condition) {
		return articleDao.search(condition);
	}
}
