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

import com.yangkids.model.dto.Comment;
import com.yangkids.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-comment")
@Api(tags = "Comment 컨트롤러")
//@CrossOrigin("*")
public class CommentRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	@Autowired
	private CommentService commentService;

	@ApiOperation(value = "댓글 목록", notes = "articleId에 해당하는 댓글 목록 가져옴")
	@GetMapping("/list/{articleId}")
	public ResponseEntity<?> list(@PathVariable int articleId) {
		List<Comment> list = commentService.getCommentList(articleId);

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 등록")
	@PostMapping("/write")
	public ResponseEntity<?> write(Comment comment) {
		try {
			int result = commentService.writeComment(comment);

			if (result == 0)
				throw new Exception();

			return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "댓글 수정")
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Comment comment) {
		int result = commentService.modifyComment(comment);

		if (result == 0) return new ResponseEntity<String>(FAIL, HttpStatus.CONFLICT);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(int commentId) {
		int result = commentService.removeComment(commentId);

		if (result == 0) return new ResponseEntity<String>(FAIL, HttpStatus.CONFLICT);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

	}

	// 예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
