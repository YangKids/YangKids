package com.yangkids.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.yangkids.util.JWTUtil;

@Component
public class SessionInterceptor implements HandlerInterceptor {
	private static final String HEADER_AUTH = "access-token";

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 브라우저에서 검증을 위해 먼저 던져보는 것이 있는데... 그거에 대해서는 따로 검사 안하고 그냥 통과시키겠다~!
		if(request.getMethod().equals("OPTIONS"))
			return true;
		
		String token = request.getHeader(HEADER_AUTH); // 헤더 안에서 access-token 이름을 가진 토큰 가져와!

		if (token != null) { // 토큰이 있으면
			jwtUtil.valid(token); // 유효성 검사 하기 => 유효성 문제 있으면 여기서 에러 던질 것임
			return true; // 여기까지 왔다면 유효성 문제없음 진행시켜~!
		}
		
		throw new Exception("유효하지 않은 접근이다.");
	}
}
