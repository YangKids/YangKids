package com.yangkids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.CommentLike;
import com.yangkids.model.service.CommentLikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-commentLike")
@Api(tags="CommentLike 컨트롤러")
public class CommentLikeRestController {
	
	@Autowired
	private CommentLikeService commentLikeService;
	
	@ApiOperation(value="좋아요 추가")
	@PostMapping("/likeup")
	public ResponseEntity<?> likeup(CommentLike commentLike){
		// 현재 userId와 commentId가 일치하는 경우, 좋아요가 되어있지 않으면 insert해주자
		int likeCnt = commentLikeService.countLike(commentLike);
		if(likeCnt==0) {
			commentLikeService.createLike(commentLike);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value="좋아요 취소")
	@DeleteMapping("/likeDown")
	public ResponseEntity<?> likeDown(CommentLike commentLike){
		int likeCnt = commentLikeService.countLike(commentLike);
		if(likeCnt == 1) {
			commentLikeService.deleteLike(commentLike);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		
	}
}
