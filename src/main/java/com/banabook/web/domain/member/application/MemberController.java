package com.banabook.web.domain.member.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/loginConfirm", 
			method=RequestMethod.POST)
	public @ResponseBody String loginConfirm(@RequestBody MemberDTO dto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO dbDTO = service.getMemberInfoToid(dto.getId());
		System.out.println(dbDTO.getPassword().equals(dto.getPassword()));
		if(dbDTO.getPassword().equals(dto.getPassword())) {
			int auID = dbDTO.getAuthority_id();
			System.out.println(auID);
			
			session.setAttribute("id", dto.getId());
			session.setAttribute("authority_id", auID);
			session.setAttribute("name", dbDTO.getName());
			
			if(auID == 30) {
				return "main";
			} else if(auID == 20) {
				return "seller_main";
			} else if(auID == 10) {
				return "main";
			}
		} else {
			return "Invalidated";
		}
		return  "Invalidated";
	}

	@RequestMapping(value="/logOut")
	public String loginConfirm(HttpServletRequest request, Model model) {
		request.getSession().invalidate();
		return "main.view";
	}
	
}
