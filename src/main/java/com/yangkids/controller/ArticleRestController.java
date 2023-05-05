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

import com.yangkids.model.dto.Article;
import com.yangkids.model.dto.SearchCondition;
import com.yangkids.model.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "Article 컨트롤러")
//@CrossOrigin("*")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;

	// 1. 게시글 목록
	@ApiOperation(value = "게시글 조회", notes = "검색 조건도 넣으면 같이 가져옴")
	@GetMapping("/article")
	public ResponseEntity<?> list(SearchCondition condition) {
		List<Article> list = articleService.search(condition);

		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	// 2. 게시글 상세보기
	@GetMapping("/article/{articleId}")
	public ResponseEntity<Article> detail(@PathVariable int articleId) {
		Article article = articleService.readArticle(articleId);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

	// 3. 게시글 등록
	@PostMapping("/article")
	public ResponseEntity<Article> write(Article article) {
		articleService.writeArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.CREATED);
	}

	// 4. 게시글 삭제
	@DeleteMapping("/article/{id}")
	public ResponseEntity<Void> delete(@PathVariable int articleId) {
		articleService.removeArticle(articleId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 5. 게시글 수정
	@PutMapping("/article")
	public ResponseEntity<Void> update(@RequestBody Article article) {
		articleService.modifyArticle(article);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
