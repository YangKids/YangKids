package com.yangkids.model.dto;

public class CommentLike {
	int commentId;
	String userId;

	public CommentLike() {
		super();
	}

	public CommentLike(int commentId, String userId) {
		super();
		this.commentId = commentId;
		this.userId = userId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CommentLike [commentId=" + commentId + ", userId=" + userId + "]";
	}

}
