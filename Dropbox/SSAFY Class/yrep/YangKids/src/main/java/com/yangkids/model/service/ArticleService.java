package com.yangkids.model.service;

import java.util.List;

import com.yangkids.model.dto.Article;
import com.yangkids.model.dto.SearchCondition;

//사용자 친화적으로
public interface ArticleService {
	//게시글 전체 조회
	public List<Article> getArticleList();
	
	//게시글 상세조회 (클릭시 읽는거)
	public Article readArticle(int id); 
	
	//게시글 작성
	public void writeArticle(Article article);
	
	//게시글 삭제 
	public void removeArticle(int id);
	
	//게시글 수정
	public void modifyArticle(Article article);
	
	//검색 버튼을 눌렀을 때 처리하기 위한 메서드
	public List<Article> search(SearchCondition condition);
	
}
