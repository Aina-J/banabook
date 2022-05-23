package com.banabook.web.domain.member.application;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.SellerMemberService;
import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.service.ProductService;

@Controller
@RequestMapping("/seller/*")
public class SellerMemberController {
	
	@Autowired
	SellerMemberService service;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/joinConfirm", method=RequestMethod.POST)
	public String insertSeller(
			Model model,
			@RequestParam("id") String id,
			@RequestParam("pw") String password,
			@RequestParam("com_name") String com_name,
			@RequestParam("cr_no") String cr_no,
			@RequestParam("name") String name,
			@RequestParam("tel") String tel,
			@RequestParam("address") String address,
			@RequestParam("birth") String birth
			) {
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setCom_name(com_name);
		dto.setCr_no(cr_no);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setBirth(birth);

		int confirm = service.insertSellerMember(dto);
		System.out.println("MESSAGE : 판매자 회원가입 성공" + confirm);
		
		return "seller_main.view";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage(Model model) {
		return "seller_mypage.view";
	}
	
	@RequestMapping(value="/manageProduct", method=RequestMethod.GET)
	public String manageProduct(Model model) {
		model.addAttribute("message", "empty");
		return "seller_manageProduct.view";
	}
	
	@RequestMapping(value="/uploadProduct", method=RequestMethod.POST)
	public String uploadProduct(Model model,
		@RequestParam("code") String code,
		@RequestParam("name") String name,
		@RequestParam("price") String price,
		@RequestParam("representative") String representative,
		@RequestParam("details") String details,
		HttpServletRequest request
		) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		int confirm = 0;
		try {
			ProductDTO dto = new ProductDTO();
			dto.setId(id);
			dto.setCode(code);
			dto.setName(name);
			dto.setPrice(Integer.parseInt(price));
			dto.setRepresentative(representative);
			dto.setDetails(details);
			confirm = productService.insertProduct(dto);
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(confirm == 0) {
			model.addAttribute("message", "error");
			System.out.println("MESSAGE : 제품 등록 실패 / 등록된 제품 수 : " + confirm);
			return "seller_manageProduct.view";
		} else {
			model.addAttribute("message", "success");
			System.out.println("MESSAGE : 제품 등록 실패 / 등록된 제품 수 : " + confirm);
			return "seller_manageProduct.view";
		}
			
	}
	
	@RequestMapping(value="/manageReview", method=RequestMethod.POST)
	public String manageReview(Model model) {
		return "main.view";
	}
	
	@RequestMapping(value="/manageInquiry", method=RequestMethod.GET)
	public String manageInquiry(Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		return "seller_qna_list.view";
	}
}
