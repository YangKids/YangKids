package com.yangkids.model.dao;

import java.util.List;

import com.yangkids.model.dto.Article;
import com.yangkids.model.dto.SearchCondition;

public interface ArticleDao {

	// articleId에 맞는 게시글 가져오기
	public Article selectOne(int articleId);

	// 게시글 등록
	public void insertArticle(Article article);

	// 게시글 삭제
	public void deleteArticle(int articleId);

	// 게시글 수정
	public void updateArticle(Article article);

	// 조회수 증가
	public void updateViewCnt(int articleid);
	
	// 검색기능
	public List<Article> search(SearchCondition condition);
	
	// 좋아요 개수
	public void updateLikeCnt(int articleId);
}
