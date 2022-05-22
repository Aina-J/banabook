package com.banabook.web.domain.inquiry.api;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.service.InquiryService;
import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.global.common.Paging;
@RestController
@RequestMapping("/inquiryApi")
public class InquriyControllerApi {
	@Autowired
	InquiryService service;
	
	@RequestMapping(value="/inquiryApi/{code}", method=RequestMethod.GET)
	public @ResponseBody Map goInquiryListPage(
			HttpServletRequest req,
			Model model
			,@PathVariable("code") String code
			) {
		List<InquiryDTO> inquiryList = service.selectProctDetailPage(code);
		System.out.println("--------여기 List사이즈------------" + inquiryList.size());
		
		
		Map map = new HashMap();
		
		if(inquiryList.size() == 0) {
	        map.put("data", "0");
	        return map;
	        
		} else {
			
			Paging paging = new Paging(inquiryList.size());
			System.out.println("paging은 : " + paging);
			
			paging.paging(Integer.parseInt(req.getParameter("page")));
			
			List<InquiryDTO> resultList = new ArrayList();
			for(int i = paging.getBeginRow() - 1; i < paging.getEndRow(); i++) {
				resultList.add(inquiryList.get(i));
			}
		
	    	map.put("beginPage", paging.getBeginPage());
	    	map.put("endPage", paging.getEndPage());
	    	map.put("section", paging.getSection());
	    	map.put("next", paging.isNext());
	    	map.put("pre", paging.isPrev());
	    	map.put("code", code);
	    	map.put("data", resultList);
	    	return map;
	    }
	}
}
