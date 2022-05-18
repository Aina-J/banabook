package com.banabook.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value="/main")
	protected  String view1(Model model) throws Exception {
		return "main.view";
	}
	
	@RequestMapping(value="/detail")
	protected  String view2(Model model) throws Exception {
		return "detail.view";
	}
	
	@RequestMapping(value="/login")
	protected  String view3(Model model) throws Exception {
		return "login.view";
	}
	
	@RequestMapping(value="/join")
	protected  String view4(Model model) throws Exception {
		return "join.view";
	}
	
	@RequestMapping(value="/seller_join")
	protected  String view6(Model model) throws Exception {
		return "sellerJoin.view";
	}
}
