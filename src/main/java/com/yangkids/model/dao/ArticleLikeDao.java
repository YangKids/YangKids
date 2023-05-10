package com.yangkids.model.dao;

import com.yangkids.model.dto.ArticleLike;

public interface ArticleLikeDao {
	
	// DAO가 DB 친화적이게
	//좋아요 눌렀니 안눌렀니??
//	int findLike(ArticleLike articleLike); 
	int select(ArticleLike articleLike);
	
	//좋아요 insert
//	int likeup(ArticleLike articleLike);
	int insert(ArticleLike articleLike);
	
	//좋아요 delete
	// parameter가 이게 맞나
//	int likeDown(ArticleLike articleLike);
	int delete(ArticleLike articleLike);
	
	int updateLikeCnt(int articleid, int delta);
}
