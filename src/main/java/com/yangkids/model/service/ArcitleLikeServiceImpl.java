package com.yangkids.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangkids.model.dao.ArticleLikeDao;
import com.yangkids.model.dto.ArticleLike;

@Service
public class ArcitleLikeServiceImpl implements ArticleLikeService {
	
	@Autowired
	private ArticleLikeDao articleLikeDao;

	// user가 article에 좋아요 눌렀는지 확인
	@Override
	public int countLike(ArticleLike articleLike) {
		return articleLikeDao.select(articleLike);
	}
	
	@Transactional
	@Override
	public int createLike(ArticleLike articleLike) {
		int added = articleLikeDao.insert(articleLike);
		//좋아요 추가됨
		if(added == 1)
			// 전체 좋아요 개수를 1 증가
			return articleLikeDao.updateLikeCnt(articleLike.getArticleId(),1);
		return 0;
	}

	@Transactional
	@Override
	public int deleteLike(ArticleLike articleLike) {
		int deleted = articleLikeDao.delete(articleLike);
		//좋아요 취소됨
		if(deleted == 1)
			// 전체 좋아요 개수를 1 감소
			return articleLikeDao.updateLikeCnt(articleLike.getArticleId(),1);
		return 0;
	}
}
