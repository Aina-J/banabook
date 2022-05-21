package com.banabook.web.domain.member.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.service.InquiryService;
import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.global.common.Paging;

@RestController
@RequestMapping("/memberApi")
public class MemberControllerApi {
	@Autowired
	InquiryService service;

	@RequestMapping(value="/inquiry/{id}", method=RequestMethod.GET)
	public Map goListPage(
			HttpServletRequest req
			,Model model
			,@PathVariable("id") String id
			) {
		List<InquiryDTO> InquiryList = service.selectAllInquiryPosts(id);
		
		System.out.println(InquiryList.size());
		
		if(InquiryList.size() == 0) {
			Map map = new HashMap();
			map.put("data", "0");
			return map;
		} else {
		Paging paging = new Paging(InquiryList.size());
		paging.paging(Integer.parseInt(req.getParameter("page")));
		
		List<InquiryDTO> resultList = new ArrayList();
		for(int i = paging.getBeginRow() - 1; i < paging.getEndRow(); i++) {
			resultList.add(InquiryList.get(i));
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

	

}
