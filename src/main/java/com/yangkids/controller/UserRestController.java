package com.yangkids.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yangkids.model.dto.User;
import com.yangkids.model.service.S3Service;
import com.yangkids.model.service.UserService;
import com.yangkids.util.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-user")
@Api(tags = "User 컨트롤러")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private S3Service s3Service;

	@Autowired
	private JWTUtil jwtUtil;

	@ApiOperation(value = "회원가입")
	@PostMapping("/signup")
	public ResponseEntity<String> signup(User user, @RequestParam("file") MultipartFile file) {
		String imgPath = s3Service.saveFile(file);
		user.setImg("https://d3brc3t3x7lzht.cloudfront.net/" + imgPath);
		int result = userService.signup(user);
		// 회원가입 성공한 경우
		if (result > 0) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
		}
		// 회원가입 실패한 경우
		return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "회원탈퇴")
	@DeleteMapping("/signout")
	public ResponseEntity<String> signout(User user) {
		// 회원 탈퇴 과정에서 아이디, 비밀번호 외에 메일 등 추가 정보들 더 쓰게 될까봐 User 객체 자체를 넘겨주도록 했습니다.
		int result = userService.signout(user);
		// 회원탈퇴 성공한 경우
		if (result > 0) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		// 회원탈퇴 실패한 경우
		return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "로그인", produces = "text/plain;charset=UTF-8")
	@PostMapping("/login")
	public ResponseEntity<?> login(User user) {
		// 반환 결과 담을 바구니 준비
		Map<String, Object> result = new HashMap<String, Object>();
		HttpStatus status = null;

		try {
			User loginUser = userService.login(user.getId(), user.getPassword());
			if (loginUser != null) { // 로그인 성공
				// 응답 정보에서 비밀번호 관련 정보만 지우기
				loginUser.setPassword(null);
				loginUser.setPasswordAnswer(null);
				loginUser.setPasswordHint(null);
				result.put("access-token", jwtUtil.createToken("id", user.getId()));
				result.put("message", "SUCCESS");
				result.put("loginUser", loginUser);
				status = HttpStatus.OK;
			} else { // 로그인 실패 (일치하는 사용자 정보 없는 경우)
				result.put("message", "FAIL");
				status = HttpStatus.NO_CONTENT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	@ApiOperation(value = "사용자 목록(관리자 페이지에서 사용)")
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<User> userList = userService.userList();
		if (userList != null || userList.size() > 0) {
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NO USER", HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/checkId")
	@ApiOperation(value = "아이디 중복 확인 - SUCCESS : 사용 가능한 아이디 / FAIL : 중복된 아이디")
	public ResponseEntity<String> checkId(String id) {
		try {
			User user = userService.searchByLoginId(id);
			if (user == null) { // 중복된 아이디 없음
				return new ResponseEntity<String>("SUCCESS", HttpStatus.OK); // 아이디 사용 가능
			} else {
				return new ResponseEntity<String>("FAIL", HttpStatus.IM_USED);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/identifyUser")
	@ApiOperation(value = "본인 확인 - 로그인 유저의 비밀번호와 입력받은 비밀번호가 일치하는지 확인")
	public ResponseEntity<?> identifyUser(int numId, String password) {
		try {
			User user = userService.identifyUser(numId, password);
			if (user != null) { // 본인확인 성공
				return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/updateUserInfo")
	@ApiOperation(value = "회원정보 수정")
	public ResponseEntity<String> updateUserInfo(User user, @RequestParam("file") MultipartFile file) {
		String imgPath = s3Service.saveFile(file);
		user.setImg("https://d3brc3t3x7lzht.cloudfront.net/" + imgPath);
		int result = userService.updateUserInfo(user);
		// 정보수정 성공한 경우
		if (result > 0) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		// 정보수정 실패한 경우
		return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
	}

//	@ApiOperation(value = "로그아웃")
//	@GetMapping("/logout")
//	public ResponseEntity<Void> logout(HttpSession session) {
//		session.removeAttribute("loginUser");
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}

	// 예외 처리
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
