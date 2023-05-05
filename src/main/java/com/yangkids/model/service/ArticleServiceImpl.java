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

	@Autowired
	public void setBoardDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article readArticle(int articleId) {
		articleDao.updateViewCnt(articleId);
		return articleDao.selectOne(articleId);
	}

	@Transactional
	@Override
	public void writeArticle(Article article) {
		articleDao.insertArticle(article);
	}

	@Transactional
	@Override
	public void removeArticle(int articleId) {
		articleDao.deleteArticle(articleId);
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
