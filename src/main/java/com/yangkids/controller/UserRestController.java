package com.yangkids.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangkids.model.dto.User;
import com.yangkids.model.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(tags = "User 컨트롤러")
//@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserService userService;

	// 1. 회원가입 (Create)
	@PostMapping("/signup")
	public ResponseEntity<?> signup(User user) {
		int result = userService.signup(user);
		// 회원가입 성공한 경우
		if (result > 0) {
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}		
		// 회원가입 실패한 경우
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	// 2. 로그인 (Read)
	@PostMapping("login")
	public ResponseEntity<?> login(User user, HttpSession session){
		User tmp = userService.login(user.getId(), user.getPassword());
		// 로그인 실패
		if(tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		// 로그인 성공
		session.setAttribute("loginUser", tmp);                  
		return new ResponseEntity<String>(tmp.getName(), HttpStatus.OK); // 일단 이름만 프론트로 돌려주기
	}
	
	
	// 3. 로그아웃 ()
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	// 4. 회원 탈퇴 (Delete)
	
}
