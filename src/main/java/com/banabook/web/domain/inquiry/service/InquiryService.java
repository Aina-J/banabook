package com.banabook.web.domain.inquiry.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;


public interface InquiryService {
	List<InquiryDTO> selectProctDetailPage(String code);
	
	InquiryDTO selectToInquiry_id(int inquiry_id);
	
	int insertMemberInquiry(InquiryDTO idto);
	
	List<InquiryDTO> checkInquiryforSeller(String sellerId);
	
	int insertSellerAnswerInquiry(InquiryDTO idto);
	
	int deleteInquiryToId(String id);
	
	List<InquiryDTO> fullListInquiryBoard(String code);
	
	List<InquiryDTO> selectAllInquiryPosts(String id);
}
