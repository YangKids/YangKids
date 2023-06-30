package com.yangkids.model.service;

import java.util.List;

import com.yangkids.model.dto.User;

public interface UserService {
	// 회원가입 (DB user 테이블에서 변경된 행 수 반환)
	public int signup(User user);
	
	// 로그인 (아이디, 비밀번호로 로그인)
	public User login(String id, String password);
	
	// 회원 탈퇴
	public int signout(User user);

	// 사용자 목록 (관리자 페이지)
	public List<User> userList();

	// 아이디 중복 확인, 비밀번호 찾기
	public User searchByLoginId(String id);
	
	// 본인 확인
	public User identifyUser(int numId, String password);
	
	// 회원정보 수정
	public int updateUserInfo(User user);

	// 학번 중복 확인
	public User searchByStudentId(String studentId);
}
