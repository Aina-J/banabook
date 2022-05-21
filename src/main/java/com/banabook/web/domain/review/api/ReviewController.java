package com.banabook.web.domain.review.api;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.review.domain.ReviewDTO;
import com.banabook.web.domain.review.service.ReviewService;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@RequestMapping(value="/insert/", method=RequestMethod.POST)
	public String insertMember(
			Model model,
			@PathVariable("code") String code,
			@RequestParam("title") String title,
			@RequestParam("content") String content
			) {
		
		System.out.println(title);
		System.out.println(content);
		
		ReviewDTO dto = new ReviewDTO();
		dto.setTitle(title);
		dto.setContent(content);
		
		return "detail.view";
	}

}
