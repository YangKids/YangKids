package com.yangkids.model.service;

import java.util.List;

import com.yangkids.model.dto.Quotation;

//사용자 친화적으로
public interface QuotationService {
	
	//명언 목록
	public List<Quotation> getQuotationList();

}