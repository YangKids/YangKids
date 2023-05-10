package com.yangkids.model.dao;

import java.util.List;

import com.yangkids.model.dto.Comment;

public interface CommentDao {
	// 게시글에 해당하는 댓글 목록
	public List<Comment> selectAll(int articleId);

	// 댓글 등록
	public int insertComment(Comment comment);

	// 댓글 삭제
	public int deleteComment(int commentId);

	// 댓글 수정
	public int updateComment(Comment comment);

}
