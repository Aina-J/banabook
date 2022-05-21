package com.banabook.web.domain.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.mapper.InquiryDAO;



@Service // component써도 되는데 service에는 service쓰는게 관행이다
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<InquiryDTO> checkInquiryforSeller(String sellerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSellerAnswerInquiry(InquiryDTO idto) {
		// TODO Auto-generated method stub
		return 0;
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
