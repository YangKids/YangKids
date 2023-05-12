package com.yangkids.model.dao;

import java.util.List;

import com.yangkids.model.dto.Article;
import com.yangkids.model.dto.SearchCondition;

public interface ArticleDao {
	
	// 게시글 목록
	public List<Article> selectAll(int boardId);

	// 게시글 상세
	public Article selectOne(int articleId);

	// 게시글 등록
	public int insertArticle(Article article);

	// 게시글 삭제
	public int deleteArticle(int articleId);

	// 게시글 수정
	public int updateArticle(Article article);

	// 조회수 증가
	public void updateViewCnt(int articleid);
	
	// 검색기능
	public List<Article> search(SearchCondition condition);

}
