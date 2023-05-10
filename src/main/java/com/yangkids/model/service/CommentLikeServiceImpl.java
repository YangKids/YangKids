package com.yangkids.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yangkids.model.dao.CommentLikeDao;
import com.yangkids.model.dto.CommentLike;


@Service
public class CommentLikeServiceImpl implements CommentLikeService {
	
	@Autowired
	private CommentLikeDao commentLikeDao;

	// user가 comment에 좋아요 눌렀는지 확인
	@Override
	public int countLike(CommentLike commentLike) {
		return commentLikeDao.select(commentLike);
	}
	
	@Transactional
	@Override
	public int createLike(CommentLike commentLike) {
		int added = commentLikeDao.insert(commentLike);
		//좋아요 추가됨
		if(added == 1)
			// 전체 좋아요 개수를 1 증가
			return commentLikeDao.updateLikeCnt(commentLike.getCommentId(),1);
		return 0;
	}

	@Transactional
	@Override
	public int deleteLike(CommentLike commentLike) {
		int deleted = commentLikeDao.delete(commentLike);
		//좋아요 취소됨
		if(deleted == 1)
			// 전체 좋아요 개수를 1 감소
			return commentLikeDao.updateLikeCnt(commentLike.getCommentId(),-1);
		return 0;
	}

}
