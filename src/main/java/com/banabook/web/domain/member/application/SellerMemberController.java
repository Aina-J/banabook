package com.banabook.web.domain.member.application;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.SellerMemberService;

@Controller
@RequestMapping("/seller/*")
public class SellerMemberController {
	
	@Autowired
	SellerMemberService service;
	
	@RequestMapping(value="/joinConfirm", method=RequestMethod.POST)
	public String insertSeller(
			Model model,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("com_name") String com_name,
			@RequestParam("cr_no") String cr_no,
			@RequestParam("name") String name,
			@RequestParam("tel") String tel,
			@RequestParam("address") String address,
			@RequestParam("birth") String birth
			) {
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(pw);
		dto.setCom_name(com_name);
		dto.setCr_no(cr_no);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setBirth(birth);

		int confirm = service.insertSellerMember(dto);
		System.out.println("MESSAGE : 판매자 회원가입 성공" + confirm);
		
		return "main.view";
	}

}
