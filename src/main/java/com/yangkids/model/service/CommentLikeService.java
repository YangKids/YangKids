package com.yangkids.model.service;

import org.springframework.stereotype.Service;

import com.yangkids.model.dto.CommentLike;


@Service
public interface CommentLikeService {
	
	// user가 comment에 좋아요 눌렀는지 확인
	public int countLike(CommentLike commentLike);
	// 좋아요 추가
	public int createLike(CommentLike commentLike);
	// 좋아요 취소
	public int deleteLike(CommentLike commentLike);
}
