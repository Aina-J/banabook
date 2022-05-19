package com.banabook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String main(Model model) {
		return "main.view";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login.view";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model) {
		return "detail.view";
	}
}
