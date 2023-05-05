package com.yangkids.model.service;

import java.util.List;

import com.yangkids.model.dto.Comment;

public interface CommentService {
	// 댓글 목록
	public List<Comment> getCommentList(int articleId);

	// 댓글 등록
	public int writeComment(Comment comment);

	// 댓글 삭제
	public int removeComment(int commentId);

	// 댓글 수정
	public int modifyComment(Comment comment);
}
