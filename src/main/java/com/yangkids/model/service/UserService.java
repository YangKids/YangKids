package com.yangkids.model.service;

import com.yangkids.model.dto.User;

public interface UserService {
	// 1. 회원가입 (DB user 테이블에서 변경된 행 수 반환)
	public int signup(User user);
	
	// 2. 로그인 (아이디, 비밀번호로 로그인)
	public User login(String id, String password);
}
