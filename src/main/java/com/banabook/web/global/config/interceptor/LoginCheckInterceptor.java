package com.banabook.web.global.config.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends  HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Interceptor---------------------------------------------------------------------------------");
		// 로그인 체크 로직
		// 세션 오브젝트 얻기
		HttpSession session = request.getSession();
		
		// 세션에 아이디가 바인딩되었나 확인 (return true || false)
		boolean sessionCheck = Optional.ofNullable((String) session.getAttribute("id"))
				.filter(e -> e != null || e != "").isPresent();
		System.out.println(sessionCheck);
		// sessionCheck 결과가 false라면 로그인 페이지로 이동
		if(!sessionCheck) {
			response.sendRedirect("/web/login/loginForm");
			return false;
		}
		return true;
	}

}
