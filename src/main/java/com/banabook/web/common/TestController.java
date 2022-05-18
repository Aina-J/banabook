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
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	protected String view2(Model model) {
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
	protected  String view5(Model model) throws Exception {
		return "seller_join.view";
	}
	@RequestMapping(value = "/my_page", method = RequestMethod.GET)
	protected String view6(Model model) {
		return "my_page.view";
	}
	@RequestMapping(value="/my_page_edit")
	protected  String view7(Model model) throws Exception {
		return "my_page_edit.view";
	}
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	protected String view8(Model model) {
		return "cart.view";
	}
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	protected String view9(Model model) {
		return "qna.view";
	}
	@RequestMapping(value = "/qna_list", method = RequestMethod.GET)
	protected String view10(Model model) {
		return "qna_list.view";
	}
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	protected String view11(Model model) {
		return "order.view";
	}
	@RequestMapping(value = "/join_menu", method = RequestMethod.GET)
	protected String view13(Model model) {
		return "join_menu.view";
	}
	@RequestMapping(value = "/list_page", method = RequestMethod.GET)
	protected String view14(Model model) {
		return "list_page.view";
	}
}
