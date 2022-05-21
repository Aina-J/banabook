package com.banabook.web.domain.member.application;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/loginConfirm", 
			method=RequestMethod.POST)
	public String loginConfirm(@RequestBody MemberDTO dto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("login확인 아이디 : " + dto.getId());
		System.out.println("login확인 비밀번호 : " + dto.getPassword());
		dto = service.getMemberInfoToid(dto.getId());
		session.setAttribute("id", dto.getId());
		session.setAttribute("authority_id", dto.getAuthority_id());
		session.setAttribute("name", dto.getName());

		return "main.view";
	}


}
