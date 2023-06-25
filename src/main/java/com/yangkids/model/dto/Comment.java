package com.yangkids.model.dto;

public class Comment {
	int commentId;
	int articleId;
	String content;
	String writerId;
	String regDate;
	int isModified;
	int likeCnt;
	int recommentCnt;
	int isAnonymous;
	String deletedAt;
	String writerName;
	String writerImg;

	public Comment() {
		super();
	}

	public Comment(int commentId, int articleId, String content, String writerId, String regDate, int isModified,
			int likeCnt, int recommentCnt, int isAnonymous, String deletedAt, String writerName, String writerImg) {
		super();
		this.commentId = commentId;
		this.articleId = articleId;
		this.content = content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.isModified = isModified;
		this.likeCnt = likeCnt;
		this.recommentCnt = recommentCnt;
		this.isAnonymous = isAnonymous;
		this.deletedAt = deletedAt;
		this.writerName = writerName;
		this.writerImg = writerImg;
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

	public int getRecommentCnt() {
		return recommentCnt;
	}

	public void setRecommentCnt(int recommentCnt) {
		this.recommentCnt = recommentCnt;
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

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getWriterImg() {
		return writerImg;
	}

	public void setWriterImg(String writerImg) {
		this.writerImg = writerImg;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", articleId=" + articleId + ", content=" + content + ", writerId="
				+ writerId + ", regDate=" + regDate + ", isModified=" + isModified + ", likeCnt=" + likeCnt
				+ ", recommentCnt=" + recommentCnt + ", isAnonymous=" + isAnonymous + ", deletedAt=" + deletedAt
				+ ", writerName=" + writerName + ", writerImg=" + writerImg + "]";
	}

	
	
}