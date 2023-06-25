package com.yangkids.model.dto;

public class Recomment {
	private int recommentId;
	private int commentId;
	private String content;
	private String writerId;
	private String regDate;
	private int isModified;
	private int isAnonymous;
	private String deletedAt;
	private String writerName;
	private String writerImg;


	public Recomment() {
		super();
	}

	public Recomment(int recommentId, int commentId, String content, String writerId, String regDate, int isModified,
			int isAnonymous, String deletedAt, 	String writerName,
	String writerImg
) {
		super();
		this.recommentId = recommentId;
		this.commentId = commentId;
		this.content = content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.isModified = isModified;
		this.isAnonymous = isAnonymous;
		this.deletedAt = deletedAt;
		this.writerName = writerName;
		this.writerImg = writerImg;
	}

	public int getRecommentId() {
		return recommentId;
	}

	public void setRecommentId(int recommentId) {
		this.recommentId = recommentId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
		return "Recomment [recommentId=" + recommentId + ", commentId=" + commentId + ", content=" + content
				+ ", writerId=" + writerId + ", regDate=" + regDate + ", isModified=" + isModified + ", isAnonymous="
				+ isAnonymous + ", deletedAt=" + deletedAt + ", writerName=" + writerName + ", writerImg=" + writerImg
				+ "]";
	}
	

}