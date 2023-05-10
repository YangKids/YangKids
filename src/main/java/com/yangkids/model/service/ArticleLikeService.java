package com.yangkids.model.service;

import org.springframework.stereotype.Service;

import com.yangkids.model.dto.ArticleLike;

@Service
public interface ArticleLikeService {
	public int countLike(ArticleLike articleLike);
	public int insertLike(ArticleLike articleLike);
	public int deleteLike(ArticleLike articleLike);
}
