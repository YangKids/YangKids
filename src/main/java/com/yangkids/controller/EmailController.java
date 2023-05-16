package com.yangkids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.service.EmailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-email")
@Api(tags = "Email 컨트롤러")
//@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	EmailService emailService;

	@PostMapping("/emailSend")
	@ApiOperation(value = "회원가입 시 인증코드가 담긴 이메일 보내기")
	public ResponseEntity<?> emailSend(String email) throws Exception {
		// 이메일 발신
		String ePW = emailService.sendSimpleMessage(email);
		
		// 인증코드 반환
		return new ResponseEntity<String>(ePW, HttpStatus.OK);
	}
}
