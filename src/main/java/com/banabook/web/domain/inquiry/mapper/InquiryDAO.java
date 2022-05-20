package com.banabook.web.domain.inquiry.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;


public interface InquiryDAO {
	
	
	/* 상품 상세페이지 이동 - 상세페이지 하단에 문의 게시판이 있기때문에 문의 게시판을 사용하려면 필요함 */
	public List<InquiryDTO> selectProctDetailPage(String code) throws DataAccessException;
	
	/* 문의 게시글로 이동 - 문의 게시판 목록에서 제목을 누르면 게시글 상세페이지로 이동 */
	public InquiryDTO selectToInquiry_id(int inquiry_id) throws DataAccessException;
	
	/* 문의 게시글 작성 */
	public int insertMemberInquiry(InquiryDTO idto) throws DataAccessException;
	
	/* 로그인한 회원 본인이 작성한 문의글을 전부 불러오는 리스트 */
	public List<InquiryDTO> selectAllInquiryPost(String id) throws DataAccessException;
	

	
	/* 상품에 해당하는 문의 게시판 전체 리스트 */
	public List<InquiryDTO> fullListInquiryBoard(String code) throws DataAccessException;
	
	
	
	/* 판매자 페이지용 - 판매자가 확인할 수 있는(본인이 판매하는) 상품 문의 게시판 */
	public List<InquiryDTO> checkInquiryforSeller(String sellerId) throws DataAccessException;
	
	/* 판매자 페이지용 - 상품 문의글에 답글 작성 */
	public int insertSellerAnswerInquiry(InquiryDTO idto) throws DataAccessException;
	
	
	/* 구매자-판매자가 작성한 글과 답글 삭제 */
	public int deleteInquiryToId(String id) throws DataAccessException;
}
