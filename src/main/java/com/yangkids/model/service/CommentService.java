package com.yangkids.model.service;

import java.util.List;

import com.yangkids.model.dto.Comment;

public interface CommentService {
	// 리뷰 목록
	public List<Comment> getCommentList(int articleId);

	// 리뷰 등록
	public int writeComment(Comment comment);

	// 리뷰 삭제
	public int removeComment(int commentId);

	// 리뷰 수정
	public int modifyComment(Comment comment);
}
