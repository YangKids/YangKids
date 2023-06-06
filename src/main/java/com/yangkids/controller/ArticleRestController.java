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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yangkids.model.dto.Article;
import com.yangkids.model.dto.SearchCondition;
import com.yangkids.model.service.ArticleService;
import com.yangkids.model.service.S3Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-article")
@Api(tags = "Article 컨트롤러")
//@CrossOrigin("*")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private S3Service s3Service;

	@ApiOperation(value = "게시글 목록")
	@GetMapping("/board/{boardId}")
	public ResponseEntity<?> board(@PathVariable int boardId){
		List<Article> list = articleService.getBoardList(boardId);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "게시글 상세")
	@GetMapping("/detail/{articleId}")
	public ResponseEntity<Article> detail(@PathVariable int articleId) {
		Article article = articleService.readArticle(articleId);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

	@ApiOperation(value = "게시글 등록")
	@PostMapping("/write")
	public ResponseEntity<?> write(Article article, @RequestParam("file") MultipartFile file) {
		String imgPath = s3Service.saveFile(file);
		article.setImg("https://d3brc3t3x7lzht.cloudfront.net/"+imgPath);
		try {
			int result = articleService.writeArticle(article);
			
			if(result==0) throw new Exception();

			return new ResponseEntity<Article>(article, HttpStatus.CREATED);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "게시글 삭제")
	@DeleteMapping("/delete/{articleId}")
	public ResponseEntity<?> delete(@PathVariable int articleId) {
		try {
			int result = articleService.removeArticle(articleId);
			
			if(result==0) throw new Exception();
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "게시글 수정")
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Article article) {
		try {
			int result = articleService.modifyArticle(article);
			
			if(result==0) throw new Exception();
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}catch (Exception e) {
            return exceptionHandling(e);
        }
	}
	
	@ApiOperation(value = "게시글 검색", notes = "key: 검색 조건, word: 검색어")
	@GetMapping("/search")
	public ResponseEntity<?> search(SearchCondition condition) {
		List<Article> list = articleService.search(condition);

		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	//예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
	     e.printStackTrace();
	     return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
