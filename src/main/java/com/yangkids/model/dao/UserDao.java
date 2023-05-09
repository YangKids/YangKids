package com.yangkids.model.dao;

import com.yangkids.model.dto.User;

public interface UserDao {

	// 1. 회원가입 (DB user 테이블에서 변경된 행 수 반환)
	public int insertUser(User user);
	
	// 2. 로그인 (아이디, 비밀번호로 로그인)
	public User selectOne(String id);
}
