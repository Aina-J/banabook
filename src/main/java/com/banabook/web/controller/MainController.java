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
@RequestMapping("/main")
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) {
		return "main.view";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login.view";
	}
}
