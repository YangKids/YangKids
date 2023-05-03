package com.yangkids.model.dto;

public class Quotation {
	int quotationId;
	String content;
	String whoSaid;

	public Quotation() {
		super();
	}

	public Quotation(int quotationId, String content, String whoSaid) {
		super();
		this.quotationId = quotationId;
		this.content = content;
		this.whoSaid = whoSaid;
	}

	public int getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWhoSaid() {
		return whoSaid;
	}

	public void setWhoSaid(String whoSaid) {
		this.whoSaid = whoSaid;
	}

	@Override
	public String toString() {
		return "Quotation [quotationId=" + quotationId + ", content=" + content + ", whoSaid=" + whoSaid + "]";
	}

}
