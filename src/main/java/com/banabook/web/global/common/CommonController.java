package com.banabook.web.global.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.AdminMemberService;
import com.banabook.web.global.common.bestseller.service.BestSellerService;

@Controller
public class CommonController {

	@Autowired
	BestSellerService bestSellerService;
	
	@Autowired
	AdminMemberService adminMemberService;
	
	@RequestMapping("/main")
	   public String main(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		model.addAttribute("id", id);
		
	      return "main.view";
	}
	
	@RequestMapping("/main") 
	public String BestSellerforMain(Model model) {	
		List list = bestSellerService.getBestSellerforMain();
		model.addAttribute("bestSellerList", list);
		return "main.view"; 
	}

	@RequestMapping("/seller_main") 
	public String sellerMain(Model model) {	
		return "seller_main.view"; 
	}	
	
	@RequestMapping("/seller_info_admin") 
	public String admin(Model model, HttpServletRequest req) {
		int page = Integer.valueOf(Optional
				.ofNullable(req.getParameter("page"))
				.orElse("1"));
		
		List<MemberDTO> list = adminMemberService.selectAllSellerInfo();
		System.out.println("size----------------------------------------" + list.size());
		List<MemberDTO> resultList = new ArrayList();
		Map map = new HashMap();
		Paging paging = null;
		if(0 < list.size()) {
			paging = new Paging(list.size());
			paging.paging(page);
			System.out.println("beginRow--------------------------------" + paging.getBeginRow());
			System.out.println("EndRow----------------------------------" + paging.getEndRow());
			for(int i = paging.getBeginRow() - 1; i < paging.getEndRow(); i++) {
				resultList.add(list.get(i));
			}
			map.put("beginPage", paging.getBeginPage());
			map.put("endPage", paging.getEndPage());
			map.put("section", paging.getSection());
			map.put("next", paging.isNext());
			map.put("pre", paging.isPrev());
			map.put("data", resultList);
			model.addAttribute("members", map);
		}
		return "seller_info_admin.view"; 
	}
	
	
	@RequestMapping("/login/loginForm")
	public String loginForm(Model model) {
		return "login.view";
	}
	
	@RequestMapping("/join/joinMenu")
	public String loginMenu(Model model) {
		return "join_menu.view";
	}
	
	@RequestMapping("/join/joinForm")
	public String joinForm(Model model) {
		return "join.view";
	}

	@RequestMapping("/join/sellerJoinForm")
	public String sellerJoinForm(Model model) {
		return "seller_join.view";
	}

}
