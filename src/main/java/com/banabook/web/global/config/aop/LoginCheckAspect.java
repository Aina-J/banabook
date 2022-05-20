package com.banabook.web.global.config.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginCheckAspect {
	
	@Before("@annotation(com.banabook.web.global.config.aop.LoginCheck)")
	public void loginCheck() {
		System.out.println("Hello AOP!!");
	}
	
}
