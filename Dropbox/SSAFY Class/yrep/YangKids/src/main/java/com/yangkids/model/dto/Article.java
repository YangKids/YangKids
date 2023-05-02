package com.yangkids.model.dto;

public class Article {
	int boardId;
	int articleId;
	String title;
	String content;
	String regDate;
	String updateDate;
	int likeCnt;
	int viewCnt;
	int isAnonymous;
	String deletedAt;
	String writerId;
	
	
	public Article() {
		super();
	}


	public Article(int boardId, int articleId, String title, String content, String regDate, String updateDate,
			int likeCnt, int viewCnt, int isAnonymous, String deletedAt, String writerId) {
		super();
		this.boardId = boardId;
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.likeCnt = likeCnt;
		this.viewCnt = viewCnt;
		this.isAnonymous = isAnonymous;
		this.deletedAt = deletedAt;
		this.writerId = writerId;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public int getArticleId() {
		return articleId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	public int getLikeCnt() {
		return likeCnt;
	}


	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}


	public int getViewCnt() {
		return viewCnt;
	}


	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
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


	public String getWriterId() {
		return writerId;
	}


	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	@Override
	public String toString() {
		return "Article [boardId=" + boardId + ", articleId=" + articleId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", updateDate=" + updateDate + ", likeCnt=" + likeCnt + ", viewCnt="
				+ viewCnt + ", isAnonymous=" + isAnonymous + ", deletedAt=" + deletedAt + ", writerId=" + writerId
				+ "]";
	}
	
	
}
