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
	
	@RequestMapping(value="/joinConfirm", 
			method=RequestMethod.POST)
	public String insertMember(
			Model model,
			HttpServletRequest request) {
		
		MemberDTO dto = new MemberDTO();
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String passwordC = request.getParameter("pw_check");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birth_string = request.getParameter("birth");
		Date birth = Date.valueOf(birth_string);
		
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setBirth(birth);
		
		String result = joinCheck(dto, passwordC);
		
		if(result == "true") {
		service.insertMember(dto);
		} else {
			System.out.println("회원가입 실패");
		}
		
		return "main.view";
	}
	
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

		return "main";
	}
	
	private String joinCheck(MemberDTO dto, String PasswordC ) {
		if("".equals(dto.getName()) || dto.getName() == null ||
				"".equals(dto.getId()) || dto.getId() == null ||
				"".equals(dto.getPassword()) || dto.getPassword() == null ||
				"".equals(PasswordC) || PasswordC == null ||
				"".equals(dto.getTel()) || dto.getTel() == null ||
				"".equals(dto.getAddress()) || dto.getAddress() == null ||
				dto.getBirth() == null) {
					System.out.println("<script>alert('모든 내용을 입력해주세요.'); location.href='/mpro/member/join.do';</script>");
		}else {
			if(PasswordC.equals(PasswordC)) {
				if(service.isIdUnique(dto.getId())) {
					System.out.println("<script>alert('아이디가 중복됩니다.'); location.href='/mpro/member/join.do';</script>");
				}else {
					return "true";
				}
			}else{
					System.out.println("<script>alert('비밀번호와 비밀번호 확인이 다릅니다.'); location.href='/mpro/member/join.do';</script>");
			}
		}
		return "false";
	}

}
