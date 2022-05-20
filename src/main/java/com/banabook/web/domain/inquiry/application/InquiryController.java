package com.banabook.web.domain.inquiry.application;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.mapper.InquiryDAO;
import com.banabook.web.domain.inquiry.service.InquiryService;

@Controller
@RequestMapping(value="/inquiry/*")
public class InquiryController {
	
	@Autowired
	InquiryService inquiryService;
	
	
	// 상품 상세페이지 이동
	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public String inquiry(
			Locale locale, Model model, 
			@RequestParam("code") String code) throws Exception {
		  List qna_list = inquiryService.selectProctDetailPage(code);
		  model.addAttribute("qna_list", qna_list);
		  
		  return "qna_list";
	}
	
	// 문의 게시글로 이동
	@RequestMapping(value = "/inquiryView", method = RequestMethod.GET)
	public String inquiryView(
			Locale locale, Model model, 
			@RequestParam("code") String code) throws Exception {
		  List qna_list = inquiryService.selectProctDetailPage(code);
		  model.addAttribute("qna_list", qna_list);
		  
		  return "qna_list";
	}
	
	
	
	
	
	
	
	
	
	// qna 작성
	@ResponseBody
	@RequestMapping(value = "/qna", method = RequestMethod.POST)
	public String qna(Locale locale, Model model, HttpServletRequest request) throws Exception {
		InquiryDTO dto = new InquiryDTO();
		dto.setName(request.getParameter("name"));
		dto.setContent(request.getParameter("content"));
		dto.setCode(request.getParameter("code"));
//		dto.setWrite_date(Date.valueOf("date"));
		
		if(service.qna(dto) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	
}
