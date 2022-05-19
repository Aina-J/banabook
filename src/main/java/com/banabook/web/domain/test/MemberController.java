package com.banabook.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banabook.web.dto.MemberDTO;
import com.banabook.web.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(Model model) {
		
		List<MemberDTO> memberList = memberService.getAdmin();
		model.addAttribute("memberList", memberList );
		
		return "memberList";
	}
}
