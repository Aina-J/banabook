package com.banabook.web.domain.inquiry.service;

import java.util.List;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;


public interface InquiryService {
	List<InquiryDTO> selectProctDetailPage(String code);
	
	InquiryDTO selectToInquiry_id(int inquiry_id);
}
