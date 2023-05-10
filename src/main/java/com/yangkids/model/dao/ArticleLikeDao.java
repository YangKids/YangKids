package com.yangkids.model.dao;

import com.yangkids.model.dto.ArticleLike;

public interface ArticleLikeDao {
	
	//좋아요 눌렀니 안눌렀니??
	int findLike(ArticleLike articleLike); 
	
	//좋아요 insert
	void likeup(ArticleLike articleLike);
	
	//좋아요 delete
	// parameter가 이게 맞나
	void likeDown(ArticleLike articleLike);
}
