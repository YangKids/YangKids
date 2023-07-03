package com.yangkids.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yangkids.model.dto.User;

public interface UserDao {

	// 회원가입 (DB user 테이블에서 변경된 행 수 반환)
	public int insertUser(User user);

	// 로그인 (아이디, 비밀번호로 로그인)
	public User selectOne(String id);

	// 회원탈퇴
	public int deleteUser(User user);

	// 사용자 목록 (관리자 페이지)
	public List<User> getUsers();

	// 아이디 중복 확인
	public User selectByLoginId(String id);

	// 본인 확인
	public User selectUser(@Param("numId") int numId, String password);

	// 학번 중복 확인
	public User selectByStudentId(String studentId);

	// 회원정보 수정
	public int updateUser(User user);

	// 학번으로 아이디 찾기
	public User selectByStudentId(String studentId);
}
