package com.banabook.web.domain.member.application;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.GnrlMemberService;

@Controller
@RequestMapping("/member/*")
public class GnrlMemberController {
	
	@Autowired
	GnrlMemberService service;
	
	@RequestMapping(value="/joinConfirm", method=RequestMethod.POST)
	public String insertMember(
			Model model,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("tel") String tel,
			@RequestParam("address") String address,
			@RequestParam("birth") String birth
			) {
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(tel);
		// String date값을 sql Date 값으로 변환
		Date birth_date = Date.valueOf(birth);
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(pw);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setBirth(birth_date);
		
		int confirm = service.insertMember(dto);
		System.out.println("MESSAGE : 회원가입 성공" + confirm);
		
		return "main.view";
	}

}
