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

import com.yangkids.model.dto.Recomment;
import com.yangkids.model.service.RecommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-recomment")
@Api(tags = "Recomment 컨트롤러")
public class RecommentRestController {

	@Autowired
	private RecommentService recommentService;

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
		try {
			int result = recommentService.modifyRecomment(recomment);

			if (result == 0)
				throw new Exception();

			return new ResponseEntity<Void>(HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "대댓글 삭제")
	@DeleteMapping("/delete/{recommentId}")
	public ResponseEntity<?> delete(@PathVariable int recommentId) {
		try {
			int result = recommentService.removeRecomment(recommentId);

			if (result == 0)
				throw new Exception();

			return new ResponseEntity<Void>(HttpStatus.OK);

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
