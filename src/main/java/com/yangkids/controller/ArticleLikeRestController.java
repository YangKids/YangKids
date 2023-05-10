package com.yangkids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.ArticleLike;
import com.yangkids.model.service.ArticleLikeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(tags="like 컨트롤러")
public class ArticleLikeRestController {
	
	@Autowired
	private ArticleLikeService articleLikeService;
	
	// 만약 like의 개수가 1이면 insert불가, delete 해야해
	// selectLike는 뭐니? -> 한명의 user가 특정 articleId에 좋아요 누른 개수 => 0개면 insert 가능, 1개면 delete 가능
	@GetMapping("/like")
	public ResponseEntity<?> findLike(ArticleLike articleId, ArticleLike userId){
		int likeCnt = articleLikeService.selectLike(articleId);
		return new ResponseEntity<Integer>(likeCnt, HttpStatus.OK);
	}
	// 1. 좋아요 추가(insert)
	@PostMapping("/likeup")
	public ResponseEntity<?> likeup(@RequestBody ArticleLike articleLike, ArticleLike articleId, ArticleLike userId) {
		if(articleLikeService.selectLike(articleLike)==0) {			
			articleLikeService.insert(articleLike);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	// 2. 좋아요 취소(delete)
	@DeleteMapping("/likeDown")
	public ResponseEntity<?> likedown(@RequestBody ArticleLike articleLike, ArticleLike articleId, ArticleLike userId){
		if(articleLikeService.selectLike(articleLike)==1) {
			articleLikeService.delete(articleLike);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);			
	}
}
