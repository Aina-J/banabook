package com.banabook.web.global.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.banabook.web.domain.member.application.MemberController;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
public class LoginCheckAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoginCheckAspect.class);
	
	@Around("@annotation(com.banabook.web.global.config.aop.LoginCheck)")
    public void logPerf(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("Befor AOP---------------------------------------------------------------------------------------");
        pjp.proceed();
        logger.info("End AOP-----------------------------------------------------------------------------------------");
    }
	
}
