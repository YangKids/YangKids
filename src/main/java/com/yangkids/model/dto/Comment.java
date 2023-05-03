package com.yangkids.model.dto;

public class Comment {
	int commentId;
	int articleId;
	String content;
	String writerId;
	String regDate;
	int isModified;
	int likeCnt;
	int isAnonymous;
	String deletedAt;

	public Comment() {
		super();
	}

	public Comment(int commentId, int articleId, String content, String writerId, String regDate, int isModified,
			int likeCnt, int isAnonymous, String deletedAt) {
		super();
		this.commentId = commentId;
		this.articleId = articleId;
		this.content = content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.isModified = isModified;
		this.likeCnt = likeCnt;
		this.isAnonymous = isAnonymous;
		this.deletedAt = deletedAt;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getIsModified() {
		return isModified;
	}

	public void setIsModified(int isModified) {
		this.isModified = isModified;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(int isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", articleId=" + articleId + ", content=" + content + ", writerId="
				+ writerId + ", regDate=" + regDate + ", isModified=" + isModified + ", likeCnt=" + likeCnt
				+ ", isAnonymous=" + isAnonymous + ", deletedAt=" + deletedAt + "]";
	}

}
