package com.banabook.web.domain.review.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.service.ProductService;
import com.banabook.web.domain.review.domain.ReviewDTO;
import com.banabook.web.domain.review.service.ReviewService;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	ReviewService service;
	@Autowired
	ProductService pservice;
	
	@RequestMapping(value="/insert/{code}", method=RequestMethod.POST)
	public String insertMember(
			Model model,
			HttpServletRequest request,
			@PathVariable("code") String code,
			@RequestParam("title") String title,
			@RequestParam("content") String content
			) {
		
		System.out.println(code);
		System.out.println(title);
		System.out.println(content);
		
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		
		ReviewDTO dto = new ReviewDTO();
		dto.setCode(code);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setId(id);
		service.insertReview(dto);
		
		ProductDTO pdto = pservice.selectCodeProductOne(code);
		
		model.addAttribute("dto", pdto);
		
		return "detail.view";
		
	}

}
