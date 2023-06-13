package com.yangkids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.User;
import com.yangkids.model.encrypt.SHA256;
import com.yangkids.model.service.EmailService;
import com.yangkids.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-email")
@Api(tags = "Email 컨트롤러")
//@CrossOrigin("*")
public class EmailRestController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserService userService;

	@PostMapping("/emailSend")
	@ApiOperation(value = "회원가입 시 인증코드가 담긴 이메일 보내기")
	public ResponseEntity<?> emailSend(String email) throws Exception {
		// 이메일 발신
		String ePW = emailService.sendSimpleMessage(email);
		
		// 인증코드 반환
		return new ResponseEntity<String>(ePW, HttpStatus.OK);
	}
	
	@PostMapping("/emailSendPw")
	@ApiOperation(value = "비밀번호 찾기 시 새로 발급된 임시 비밀번호가 담긴 이메일 보내기")
	public ResponseEntity<String> emailSendPw(String id) throws Exception {
		// 해당 로그인 아이디를 가지는 유저 정보 찾기
		User user = userService.searchByLoginId(id);

		// 해당 아이디를 가지는 유저가 없는 경우
		if (user == null) {
			return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
		}

		// 임시 비밀번호 생성 & 이메일 발신
		String newPw = emailService.sendNewPw(user.getEmail());

		user.setPassword(newPw);

		// 사용자의 비밀번호도 임시비밀번호로 수정
		userService.updateUserInfo(user);

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
}
