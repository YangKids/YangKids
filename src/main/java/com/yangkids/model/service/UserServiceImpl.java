package com.yangkids.model.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangkids.model.dao.UserDao;
import com.yangkids.model.dto.User;
import com.yangkids.model.encrypt.SHA256;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	private SHA256 sha = new SHA256();

	// 1. 회원가입 (DB user 테이블에서 변경된 행 수 반환)
	@Override
	public int signup(User user) {
		try {
			// 비밀번호 암호화
			String encPw = sha.doEncrypt(user.getPassword());
			user.setPassword(encPw); // 암호화된 비밀번호로 변경
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return userDao.insertUser(user);
	}

	// 2. 로그인 (아이디, 비밀번호로 로그인)
	@Override
	public User login(String id, String password) {
		User tmp = userDao.selectOne(id); // DB에서 id 기준으로 일치하는 사용자 있는지 검색

		try {
			// DB에 암호화된 비밀번호 저장되어 있기 때문에 비교를 위해 입력받은 비밀번호도 암호화.
			String encPw = sha.doEncrypt(password);
			// 로그인 성공 (id, password 일치하는 사용자 있음)
			if (tmp != null && tmp.getPassword().equals(encPw)) {
				return tmp;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// 로그인 실패
		return null;
	}

	@Override
	public int signout(User user) {
		try {
			String encPw = sha.doEncrypt(user.getPassword());
			user.setPassword(encPw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return userDao.deleteUser(user);
	}

	@Override
	public List<User> userList() {
		return userDao.getUsers();
	}

	@Override
	public User searchByLoginId(String id) {
		return userDao.selectByLoginId(id);
	}

	@Override
	public User identifyUser(int numId, String password) {
		try {
			return userDao.selectUser(numId, sha.doEncrypt(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 본인확인 실패
		return null;
	}

	@Override
	public int updateUserInfo(User user) {
		try {
			// 비밀번호 암호화
			String encPw = sha.doEncrypt(user.getPassword());
			user.setPassword(encPw); // 암호화된 비밀번호로 변경
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return userDao.updateUser(user);
	}
}
