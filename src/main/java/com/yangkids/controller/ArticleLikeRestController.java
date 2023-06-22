package com.yangkids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.Alarm;
import com.yangkids.model.dto.ArticleLike;
import com.yangkids.model.service.AlarmService;
import com.yangkids.model.service.ArticleLikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-articleLike")
@Api(tags = "ArticleLike 컨트롤러")
public class ArticleLikeRestController {

	@Autowired
	private ArticleLikeService articleLikeService;

	@Autowired
	private AlarmService alarmService;

	@ApiOperation(value = "좋아요 추가")
	@PostMapping("/likeup")
	public ResponseEntity<?> likeup(ArticleLike articleLike) {
		try {
			// 현재 userId와 articleId가 일치하는 경우 좋아요가 되어있지 않으면 insert해주자
			int likeCnt = articleLikeService.countLike(articleLike);
			if (likeCnt == 0) {
				int insertResult = articleLikeService.createLike(articleLike);
				Alarm alarm = new Alarm();
				alarm.setArticleId(articleLike.getArticleId());
				alarm.setType("좋아요");
				alarm.setUserId(articleLike.getUserId());
				alarmService.writeAlarm(alarm);
				// 좋아요 추가에 실패했으면 예외발생
				if (insertResult == 0)
					throw new Exception();
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			// 현재 userId와 articleId가 일치하는 경우 좋아요가 되어있는데 insert 시도하면 BAD_REQUEST 발생
			return new ResponseEntity<String>("already pressed like", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "좋아요 취소")
	@DeleteMapping("/likeDown")
	public ResponseEntity<?> likeDown(ArticleLike articleLike) {
		try {
			// 현재 userId와 articleId가 일치하는 경우 좋아요가 되어있으면 delete해주자
			int likeCnt = articleLikeService.countLike(articleLike);
			if (likeCnt == 1) {
				int deleteResult = articleLikeService.deleteLike(articleLike);
				// 좋아요 삭제에 실패했으면 예외발생
				if (deleteResult == 0)
					throw new Exception();
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			// 현재 userId와 articleId가 일치하는 경우 좋아요가 되어있지않는데 delete 시도하면 BAD_REQUEST 발생
			return new ResponseEntity<String>("didn`t press like", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	// 예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
