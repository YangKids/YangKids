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
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public List<Article> getBoardList(int boardId) {
		return articleDao.selectAll(boardId);
	}
	
	@Override
	public Article readArticle(int articleId) {
		articleDao.updateViewCnt(articleId);
		return articleDao.selectOne(articleId);
	}

	@Transactional
	@Override
	public int writeArticle(Article article) {
		int result = articleDao.insertArticle(article);
		return result;
	}

	@Transactional
	@Override
	public int removeArticle(int articleId) {
		int result = articleDao.deleteArticle(articleId);
		return result;
	}

	@Transactional
	@Override
	public int modifyArticle(Article article) {
		int result = articleDao.updateArticle(article);
		return result;
	}

	@Override
	public List<Article> search(SearchCondition condition) {
		return articleDao.search(condition);
	}

}
