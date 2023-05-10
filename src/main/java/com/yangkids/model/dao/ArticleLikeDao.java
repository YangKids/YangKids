package com.yangkids.model.dao;

import com.yangkids.model.dto.ArticleLike;

public interface ArticleLikeDao {

	//좋아요 눌렀니 안눌렀니??
	public int select(ArticleLike articleLike);
	
	//좋아요 insert
	public int insert(ArticleLike articleLike);
	
	//좋아요 delete
	public int delete(ArticleLike articleLike);
	
	// 좋아요 전체 개수 update
	public int updateLikeCnt(int articleId, int delta);
}
