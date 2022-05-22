package com.banabook.web.domain.inquiry.application;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.mapper.InquiryDAO;
import com.banabook.web.domain.inquiry.service.InquiryService;
import com.banabook.web.domain.product.service.ProductService;

@Controller
@RequestMapping(value="/qna/*")
public class InquiryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);
	
	@Autowired
	InquiryService inquiryService;
	
	@Autowired
	ProductService pservice;
	
	// 상품 상세페이지 이동
//	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
//	public String inquiry(
//			Locale locale, Model model, 
//			@RequestParam("code") String code) throws Exception {
//		List qna_list = inquiryService.selectProctDetailPage(code);
//		model.addAttribute("qna_list", qna_list);
//		  
//		  return "qna_list";
//	}
//	
//	// 문의 게시글로 이동
//	@RequestMapping(value = "/inquiryView", method = RequestMethod.GET)
//	public InquiryDTO inquiryView(
//			Locale locale, Model model, 
//			@RequestParam("inquiry_id") int inquiry_id) throws Exception {
//		InquiryDTO dto = inquiryService.selectToInquiry_id(inquiry_id);
//		return dto;
//	}
	
	// 문의 게시글 작성
	
	@PostMapping(value="/meminsert/{code}")
	public String inquiryReg(Model model,	HttpServletRequest request,  
	  @RequestParam Integer inquiry_id, 	@PathVariable("code") String code,
	  @RequestParam String title, 			@RequestParam String content,
	  @RequestParam String pi_id)	 {
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
	
			InquiryDTO dto = new InquiryDTO();
			dto.setInquiry_id(inquiry_id);
			dto.setId(id);
			dto.setCode(code);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setPi_id("0");
			inquiryService.insertMemberInquiry(dto);
			
			logger.info("문의글이 등록됩니다");
			logger.info(title);
			logger.info(code);
			
			return "detail.view";	
	}	
	
	
	// 판매자용 문의게시글 답글 작성

//	@PostMapping(value="/selinsert/{code}")
//	public String inquiryReg(Model model, InquiryDTO dto,  HttpServletRequest request) {
	
	@PostMapping(value="/selinsert/{code}")
	public String inquiryReply(Model model, HttpServletRequest request,
		@RequestParam Integer inquiry_id, @PathVariable("code") String code,
		@RequestParam String title, 	  @RequestParam String content,
		@RequestParam String pi_id) {
	
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			
			InquiryDTO dto = new InquiryDTO();
			dto.setId(id);
			dto.setCode(code);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setPi_id(String.valueOf(inquiry_id));
			inquiryService.insertSellerAnswerInquiry(dto);
			
			logger.info("문의글이 등록됩니다");

			return "detail.view";	
	}
	
	
	// 게시글 지우기
	
	@RequestMapping(value="/qna/delete", method = RequestMethod.GET) 
	public String qnaDelete (HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		inquiryService.deleteInquiryToId(id);
		
		logger.info("문의글이 지워졌습니다");
		
		return "detail.view";
	}
		
}	
