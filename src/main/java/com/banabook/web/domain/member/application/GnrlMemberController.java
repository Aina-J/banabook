package com.banabook.web.domain.member.application;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.GnrlMemberService;
import com.banabook.web.domain.review.domain.ReviewDTO;

@Controller
@RequestMapping("/general/*")
public class GnrlMemberController {
	
	@Autowired
	GnrlMemberService service;
	
	// 회원 가입 진행
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

		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(pw);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setBirth(birth);
		
		int confirm = service.insertMember(dto);
		
		if(confirm == 1) {
			System.out.println("MESSAGE : 회원가입 성공 / 등록된 회원 수 : " + confirm);
		} else {
			System.out.println("MESSAGE : 회원가입 실패 / 등록된 회원 수 : " + confirm);
		}
		return "main.view";
	}
	// 회원 마이페이지 진입
		@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
		public String enterMypage(Model model, HttpServletRequest request) {
//			HttpSession session = request.getSession();
//			String id = (String) session.getAttribute("id");
//			
//			// 로그인 정보 없을시 로그인 화면으로 이동
//			if(id == "" || id == null ) {
//				return "login.view";
//			} else {
//				return "my_page.view";
//			}
			
			return "my_page.view";
		}
		
	// 회원 수정페이지 진입
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String enterMemberEdit(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberDTO dto = service.selectMemberToID(id);
		
		model.addAttribute("id", id);
		model.addAttribute("dto", dto);
		
		
		return "my_page_edit.view";
	}
	
	// 회원 수정 요청
	@RequestMapping(value="/editConfirm", method=RequestMethod.POST)
	public String updateMember(
			Model model,
			HttpServletRequest request,
			@RequestParam("pw") String password,
			@RequestParam("name") String name,
			@RequestParam("tel") String tel,
			@RequestParam("address") String address,
			@RequestParam("birth") String birth
			) {
		
		// 세션에서 아이디 정보 불러옴
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setBirth(birth);
		int result = service.updateMember(dto);
		if(result == 1) {
			System.out.println("MESSAGE : 회원정보 수정 완료 ");
		} else {
			System.out.println("MESSAGE : 회원정보 수정 실패 ");
		}
		
		return "my_page.view";
	}
	
	// 회원이 작성한 문의 게시글 리스트 출력
	@RequestMapping(value="/loadInquiry.do", method=RequestMethod.GET)
	public String loadInquiry(
			Model model,
			HttpServletRequest request
			) {
		return "qna_list.view";
	}
}
