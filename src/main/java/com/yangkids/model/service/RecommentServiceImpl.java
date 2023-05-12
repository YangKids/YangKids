package com.yangkids.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangkids.model.dao.RecommentDao;
import com.yangkids.model.dto.Recomment;
@Service
public class RecommentServiceImpl implements RecommentService {

	@Autowired
	private RecommentDao recommentDao;
	
	@Override
	public List<Recomment> getRecommentList(int commentId) {
		return recommentDao.selectAll(commentId);
	}

	@Transactional
	@Override
	public int writeRecomment(Recomment recomment) {
		int result = recommentDao.insertRecomment(recomment);
		return result;
	}

	@Transactional
	@Override
	public int removeRecomment(int recommentId) {
		int result = recommentDao.deleteRecomment(recommentId);
		return result;
	}

	@Transactional
	@Override
	public int modifyRecomment(Recomment recomment) {
		int result = recommentDao.updateRecomment(recomment);
		return result;
	}

}
