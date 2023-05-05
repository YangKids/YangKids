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

@RestController
@RequestMapping("/api")
@Api(tags = "Comment 컨트롤러")
//@CrossOrigin("*")
public class CommentRestController {

	@Autowired
	private CommentService commentService;
	
	//게시글 별 댓글 목록
	@GetMapping("/comment")
	public ResponseEntity<?> list(int articleId){
		List<Comment> list = commentService.getCommentList(articleId);
		
		//가져올 게시글 없으면
		if(list==null || list.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}
	
	
	//댓글 등록
	@PostMapping("/comment")
	public ResponseEntity<?> write(Comment comment){
		try {
			int result = commentService.writeComment(comment);
			
			//리뷰 등록에 실패했으면 예외발생
			if(result==0) throw new Exception();
			
			return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
			
		}catch (Exception e) {
            return exceptionHandling(e);
        }
	}
	
	//댓글 수정
	@PutMapping("/comment")
	public ResponseEntity<?> update(@RequestBody Comment comment){
		try {
			int result = commentService.modifyComment(comment);
			
			//리뷰 수정에 실패했으면 예외발생
			if(result==0) throw new Exception();
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}catch (Exception e) {
            return exceptionHandling(e);
        }
	}
	
	//댓글 삭제
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<?> delete(@PathVariable int commentId){
		try {
			int result = commentService.removeComment(commentId);
			
			//리뷰 삭제에 실패했으면 예외발생
			if(result==0) throw new Exception();
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}catch (Exception e) {
            return exceptionHandling(e);
        }
	}
	
	//예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
