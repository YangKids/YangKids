package com.yangkids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.Alarm;
import com.yangkids.model.dto.Recomment;
import com.yangkids.model.service.AlarmService;
import com.yangkids.model.service.RecommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-recomment")
@Api(tags = "Recomment 컨트롤러")
public class RecommentRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	@Autowired
	private RecommentService recommentService;

	@Autowired
	private AlarmService alarmService;

	@ApiOperation(value = "대댓글 목록", notes = "commentId에 해당하는 대댓글 목록 가져옴")
	@GetMapping("/list/{commentId}")
	public ResponseEntity<?> list(@PathVariable int commentId) {
		List<Recomment> list = recommentService.getRecommentList(commentId);

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Recomment>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "대댓글 등록")
	@PostMapping("/write")
	public ResponseEntity<?> write(Recomment recomment) {
		try {
			int result = recommentService.writeRecomment(recomment);

			Alarm alarm = new Alarm();
			alarm.setCommentId(recomment.getCommentId());
			alarm.setRecommentId(recomment.getRecommentId());
			alarm.setType("댓글");
			alarm.setUserId(recomment.getWriterId());
			alarmService.writeAlarm(alarm);
			if (result == 0)
				throw new Exception();

			return new ResponseEntity<Recomment>(recomment, HttpStatus.CREATED);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "대댓글 수정")
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Recomment recomment) {
		int result = recommentService.modifyRecomment(recomment);

		if (result == 0)
			return new ResponseEntity<String>(FAIL, HttpStatus.CONFLICT);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "대댓글 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(int recommentId) {
		int result = recommentService.removeRecomment(recommentId);

		if (result == 0)
			return new ResponseEntity<String>(FAIL, HttpStatus.CONFLICT);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

	}

	// 예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
