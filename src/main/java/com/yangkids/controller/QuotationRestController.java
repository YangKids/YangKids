package com.yangkids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.yangkids.model.dto.Quotation;
import com.yangkids.model.dto.SearchCondition;
import com.yangkids.model.service.QuotationService;
import com.yangkids.model.service.S3Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-quotation")
@Api(tags = "Quotation 컨트롤러")
@CrossOrigin("*")
public class QuotationRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";
	
	@Autowired
	private QuotationService quotationService;


	@ApiOperation(value = "게시글 목록")
	@GetMapping("/quotation")
	public ResponseEntity<?> quotation(){
		List<Quotation> list = quotationService.getQuotationList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Quotation>>(list, HttpStatus.OK);
	}


	//예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
	     e.printStackTrace();
	     return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
