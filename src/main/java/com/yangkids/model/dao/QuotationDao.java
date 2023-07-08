package com.yangkids.model.dao;

import java.util.List;

import com.yangkids.model.dto.Quotation;

public interface QuotationDao {
	// 알람 목록
	public List<Quotation> selectAll();

}
