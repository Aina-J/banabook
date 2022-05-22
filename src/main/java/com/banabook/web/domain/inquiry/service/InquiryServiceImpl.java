package com.banabook.web.domain.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.mapper.InquiryDAO;


@Service 
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	InquiryDAO inquiryDAO;
	
	@Override
	public List<InquiryDTO> selectProctDetailPage(String code) {
		return inquiryDAO.selectProctDetailPage(code);
	}

	@Override
	public InquiryDTO selectToInquiry_id(int inquiry_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMemberInquiry(InquiryDTO idto) {
		return inquiryDAO.insertMemberInquiry(idto);
	}

	@Override
	public List<InquiryDTO> checkInquiryforSeller(String sellerId) {
		return inquiryDAO.checkInquiryforSeller(sellerId);
	}

	@Override
	public int insertSellerAnswerInquiry(InquiryDTO idto) {
		return inquiryDAO.insertSellerAnswerInquiry(idto);
	}

	@Override
	public int deleteInquiryToId(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<InquiryDTO> fullListInquiryBoard(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InquiryDTO> selectAllInquiryPosts(String id) {
		return inquiryDAO.selectAllInquiryPosts(id);
	}

}
