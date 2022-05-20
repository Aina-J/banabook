package com.banabook.web.global.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banabook.web.global.common.bestseller.service.BestSellerService;

@Controller
public class CommonController {

	@Autowired
	BestSellerService bestSellerService;
	
	@RequestMapping("/main")
	   public String main(Model model) {
	      return "main.view";
	}

	@RequestMapping("/maintest") 
	public String BestSellerforMain(Model model) {	
		List list = bestSellerService.getBestSellerforMain();
		model.addAttribute("bestSellerList", list);
		return "main.view"; 
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
