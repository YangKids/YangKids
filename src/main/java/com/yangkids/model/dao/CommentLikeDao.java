package com.yangkids.model.dao;

import com.yangkids.model.dto.CommentLike;

public interface CommentLikeDao {

	//좋아요 눌렀니 안눌렀니??
	public int select(CommentLike commentLike);
	
	//좋아요 insert
	public int insert(CommentLike commentLike);
	
	//좋아요 delete
	public int delete(CommentLike commentLike);
	
	// 좋아요 전체 개수 update
	public int updateLikeCnt(int commentId, int delta);
}
