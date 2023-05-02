package com.yangkids.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "게시판 바구니", description = "게시글 정보")
public class ArticleLike {
	int articleId;
	String userId;

	public ArticleLike() {
		super();
	}

	public ArticleLike(int articleId, String userId) {
		super();
		this.articleId = articleId;
		this.userId = userId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ArticleLike [articleId=" + articleId + ", userId=" + userId + "]";
	}

}
