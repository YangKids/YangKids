package com.yangkids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.ArticleLike;
import com.yangkids.model.service.ArticleLikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-like")
@Api(tags="Like 컨트롤러")
public class ArticleLikeRestController {
	
	@Autowired
	private ArticleLikeService articleLikeService;
	
	@ApiOperation(value="좋아요 추가")
	@PostMapping("/likeup")
	public ResponseEntity<?> likeup(ArticleLike articleLike){
		// 현재 userId와 articleId가 일치하는 경우 좋아요가 되어있지 않으면 insert해주자
		int likeCnt = articleLikeService.countLike(articleLike);
		if(likeCnt==0) {
			articleLikeService.createLike(articleLike);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value="좋아요 취소")
	@DeleteMapping("/likeDown")
	public ResponseEntity<?> likeDown(ArticleLike articleLike){
		int likeCnt = articleLikeService.countLike(articleLike);
		if(likeCnt == 1) {
			articleLikeService.deleteLike(articleLike);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		
	}
}
