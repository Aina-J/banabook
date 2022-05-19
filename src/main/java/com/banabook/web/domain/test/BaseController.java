package com.banabook.web.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class BaseController {

	@RequestMapping(value="/login/loginForm" ,method={RequestMethod.POST,RequestMethod.GET})
	protected  String viewForm(HttpServletRequest request, Model model) throws Exception {
		return "login.view";
	}

}
