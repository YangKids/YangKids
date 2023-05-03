package com.yangkids.model.dto;

public class Alarm {
	int alarmId;
	String type;
	String userId;
	String regDate;
	int articleId;
	int commentId;
	int recommentId;
	int isChecked;
	
	
	
	public Alarm() {
	}

	public Alarm(int alarmId, String type, String userId, String regDate, int articleId, int commentId, int recommentId,
			int isChecked) {
		super();
		this.alarmId = alarmId;
		this.type = type;
		this.userId = userId;
		this.regDate = regDate;
		this.articleId = articleId;
		this.commentId = commentId;
		this.recommentId = recommentId;
		this.isChecked = isChecked;
	}

	public int getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getRecommentId() {
		return recommentId;
	}

	public void setRecommentId(int recommentId) {
		this.recommentId = recommentId;
	}

	public int getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String toString() {
		return "Alarm [alarmId=" + alarmId + ", type=" + type + ", userId=" + userId + ", regDate=" + regDate
				+ ", articleId=" + articleId + ", commentId=" + commentId + ", recommentId=" + recommentId
				+ ", isChecked=" + isChecked + "]";
	}
	
	
}
