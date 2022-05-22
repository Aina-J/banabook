package com.banabook.web.domain.review.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.review.domain.ReviewDTO;
import com.banabook.web.domain.review.mapper.ReviewDAO;

@Service
public class ReviewService {

	
	@Autowired
	ReviewDAO reviewDAO;
	

	public List<ReviewDTO> selectReviewList(String code) {
		return reviewDAO.selectReviewList(code);
	}
	
	public void insertReview(ReviewDTO rDTO) {
		reviewDAO.insertReview(rDTO);
	}
	
}
