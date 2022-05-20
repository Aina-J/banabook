package com.banabook.web.domain.review.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banabook.web.domain.review.domain.ReviewDTO;
import com.banabook.web.domain.review.service.ReviewService;

@RestController
@RequestMapping("/reviewApi")
public class ReviewControllerApi {

	@Autowired
	ReviewService service;

	// 상품코드를 가지고 그 상품의 리뷰만 조회하는 메서드
	@RequestMapping(value="/reviewApi/{code}", method=RequestMethod.GET)
	public @ResponseBody List<ReviewDTO> goListPage(
			Model model
			,@PathVariable("code") String code
			) {
		List<ReviewDTO> reviewList = service.selectReviewList(code);
		
		
		System.out.println("--------여기 ------------" + reviewList.size());
		
		return reviewList;
	}

}
