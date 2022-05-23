package com.banabook.web.domain.member.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.service.AdminMemberService;
import com.banabook.web.domain.member.service.SellerMemberService;
import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.service.ProductService;
import com.banabook.web.global.common.Paging;

@Controller
@RequestMapping("/adminApi/*")
public class AdminMemberControllerApi {
	
	@Autowired
	AdminMemberService service;
	@Autowired
	ProductService productService;
	@Autowired
	SellerMemberService sellerService;
	@Autowired
	AdminMemberService adminMemberService;
	
	/* 관리자페이지에서 판매자승인리스트 조회 */
	@RequestMapping(value="/sellerInfo", method=RequestMethod.GET)
	public Map aprvlList(
			HttpServletRequest req
			,Model model
			) {
			
		System.out.println("page : " + req.getParameter("page"));
		List<MemberDTO> aprvlList = service.selectAllSellerInfo();
		if(aprvlList.size() == 0) {
			Map map = new HashMap();
			map.put("data", "0");
			return map;
		} else {
			Paging paging = new Paging(aprvlList.size());
			paging.paging(Integer.parseInt(req.getParameter("page")));
		
			List<MemberDTO> resultList = new ArrayList();
			for(int i = paging.getBeginRow() - 1 ; i < paging.getEndRow() ; i++) {
				resultList.add(aprvlList.get(i));
			}
			
			Map map = new HashMap();
			map.put("beginPage", paging.getBeginPage());
			map.put("endPage", paging.getEndPage());
			map.put("section", paging.getSection());
			map.put("next", paging.isNext());
			map.put("pre", paging.isPrev());
			map.put("data", resultList);
			

			return map;
		}
		
	}
	
	/* 관리자페이지에서 판매자 승인 해주는 기능 */
	@RequestMapping(value="/sellerAprvl", method=RequestMethod.POST)
	public String updateSellerAprvl(
			Model model,
			@RequestParam("id") String id,
			@RequestParam("entry") Integer entry
			) {
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setEntry(entry);

		int confirm = sellerService.updateSellerMember(dto);
		
		
		int page = 1;
		System.out.println("MESSAGE : 판매자 입점승인 변경 성공" + confirm);
		List<MemberDTO> list = adminMemberService.selectAllSellerInfo();
		System.out.println("size----------------------------------------" + list.size());
		List<MemberDTO> resultList = new ArrayList();
		Map map = new HashMap();
		Paging paging = null;
		if(0 < list.size()) {
			paging = new Paging(list.size());
			paging.paging(page);
			System.out.println("beginRow--------------------------------" + paging.getBeginRow());
			System.out.println("EndRow----------------------------------" + paging.getEndRow());
			for(int i = paging.getBeginRow() - 1; i < paging.getEndRow(); i++) {
				resultList.add(list.get(i));
			}
			map.put("beginPage", paging.getBeginPage());
			map.put("endPage", paging.getEndPage());
			map.put("section", paging.getSection());
			map.put("next", paging.isNext());
			map.put("pre", paging.isPrev());
			map.put("data", resultList);
			model.addAttribute("members", map);
		}
		
		return "seller_info_admin.view";
	}
	
}
