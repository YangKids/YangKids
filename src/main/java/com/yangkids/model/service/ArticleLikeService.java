package com.yangkids.model.service;

import org.springframework.stereotype.Service;

import com.yangkids.model.dto.ArticleLike;

@Service
public interface ArticleLikeService {
	public int selectLike(ArticleLike articleLike);
	public void insert(ArticleLike articleLike);
	public void delete(ArticleLike articleLike);
}
