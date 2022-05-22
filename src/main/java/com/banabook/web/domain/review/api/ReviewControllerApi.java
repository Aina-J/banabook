package com.banabook.web.domain.review.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.review.domain.ReviewDTO;
import com.banabook.web.domain.review.service.ReviewService;
import com.banabook.web.global.common.Paging;

@RestController
@RequestMapping("/reviewApi")
public class ReviewControllerApi {

	@Autowired
	ReviewService service;

	// 상품코드를 가지고 그 상품의 리뷰만 조회하는 메서드
	@RequestMapping(value="/reviewApi/{code}", method=RequestMethod.GET)
	public @ResponseBody Map goListPage(
			HttpServletRequest req,
			Model model
			,@PathVariable("code") String code
			) {
		List<ReviewDTO> reviewList = service.selectReviewList(code);
		
		
		Paging paging = new Paging(reviewList.size());
		System.out.println("paging은 : " + paging);
		
		paging.paging(Integer.parseInt(req.getParameter("page")));
		
		List<ReviewDTO> resultList = new ArrayList();
		for(int i = paging.getBeginRow() - 1; i < paging.getEndRow(); i++) {
			resultList.add(reviewList.get(i));
		}
		
		Map map = new HashMap();
		map.put("beginPage", paging.getBeginPage());
		map.put("endPage", paging.getEndPage());
		map.put("section", paging.getSection());
		map.put("next", paging.isNext());
		map.put("pre", paging.isPrev());
		map.put("code", code);
		map.put("data", resultList);
		
		System.out.println("--------여기 List사이즈------------" + reviewList.size());
		System.out.println("-----------여기 코드--------------" + code);
		
		return map;
		
	}
	
	
	// 리뷰 작성 메서드
	@RequestMapping(value="/reviewInsertApi/{code}", method=RequestMethod.POST)
	public @ResponseBody String insertReview(
			HttpServletRequest req,
			Model model
			,@PathVariable("code") String code
			,@RequestParam("title") String title
			,@RequestParam("content") String content
			) {
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		
		ReviewDTO dto = new ReviewDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setCode(code);
		
		service.insertReview(dto);
		
		return "리뷰등록완료";
	}
	
	
	
	
	

}
