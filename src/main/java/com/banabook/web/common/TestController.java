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
	@RequestMapping(value ="/join_menu")
	protected String view2(Model model) {
		return "join_menu.view";
	}
	@RequestMapping(value="/join")
	protected  String view3(Model model) throws Exception {
		return "join.view";
	}
	@RequestMapping(value="/seller_join")
	protected  String view4(Model model) throws Exception {
		return "sellerJoin.view";
	}
	@RequestMapping(value="/login")
	protected  String view5(Model model) throws Exception {
		return "login.view";
	}
	@RequestMapping(value="/mypage")
	protected  String view6(Model model) throws Exception {
		return "mypage.view";
	}
	@RequestMapping(value="/mypage_edit")
	protected  String view7(Model model) throws Exception {
		return "mypage_edit.view";
	}
	@RequestMapping(value ="/list_page")
	protected String view8(Model model) {
		return "list_page.view";
	}
	@RequestMapping(value="/detail")
	protected  String view9(Model model) throws Exception {
		return "detail.view";
	}
	@RequestMapping(value ="/cart")
	protected String view10(Model model) {
		return "cart.view";
	}
	@RequestMapping(value ="/qna")
	protected String view11(Model model) {
		return "qna.view";
	}
	@RequestMapping(value ="/qna_list")
	protected String view12(Model model) {
		return "qna_list.view";
	}
	@RequestMapping(value ="/order")
	protected String view13(Model model) {
		return "order.view";
	}
	
}
