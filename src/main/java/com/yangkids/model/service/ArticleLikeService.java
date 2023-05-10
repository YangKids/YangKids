package com.yangkids.model.service;

import org.springframework.stereotype.Service;

import com.yangkids.model.dto.ArticleLike;

@Service
public interface ArticleLikeService {
	
	// user가 article에 좋아요 눌렀는지 확인
	public int countLike(ArticleLike articleLike);
	// 좋아요 추가
	public int createLike(ArticleLike articleLike);
	// 좋아요 취소
	public int deleteLike(ArticleLike articleLike);
}
