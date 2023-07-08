package com.yangkids.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangkids.model.dao.QuotationDao;
import com.yangkids.model.dto.Quotation;

@Service
public class QuotationServiceImpl implements QuotationService {

	private QuotationDao quotationDao;

	@Autowired
	public void setQuotationDao(QuotationDao quotationDao) {
		this.quotationDao = quotationDao;
	}

	@Override
	public List<Quotation> getQuotationList() {
		return quotationDao.selectAll();
	}

}
