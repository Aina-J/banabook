package com.banabook.web.domain.review.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.review.domain.ReviewDTO;


public interface ReviewDAO {
	
	/* 리뷰 게시글 작성 */
	public void insertReview(ReviewDTO rDTO)  throws DataAccessException;
	
	/* 리뷰 작성자 확인 (ID 매칭) */
	public String checkAuthorReview(String review_id) throws DataAccessException;
	
	/* 리뷰 작성자 확인 후 (로그인 된 회원의 ID 매칭이 맞으면) 리뷰 수정 */
	public void editReviewMemOnly(ReviewDTO rDTO) throws DataAccessException;
	
	/* 리뷰 작성자 확인 후 (로그인 된 회원의 ID 매칭이 맞으면) 리뷰 삭제 */
	public int deleteReviewMemOnly(String review_id) throws DataAccessException;

	/* 상품코드에 해당하는 상품에 작성된 모든 리뷰를 리스트로 반환 */
	public List<ReviewDTO> selectReviewList(String code) throws DataAccessException;
	
	/* 회원 탈퇴를 할 경우 본인/관리자가 작성한 리뷰를 전체 삭제 */
	public int deleteAllReview(String id) throws DataAccessException;
}