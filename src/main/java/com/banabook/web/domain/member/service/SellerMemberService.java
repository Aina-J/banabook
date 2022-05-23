package com.banabook.web.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.mapper.InquiryDAO;
import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.repository.SellerMemberDAO;

@Service
public class SellerMemberService {
	
	@Autowired
	SellerMemberDAO sellerDAO;
	
	@Autowired
	InquiryDAO inquiryDAO;
	
	public int insertSellerMember(MemberDTO dto) {
		return sellerDAO.insertSellerMember(dto);
	}
	
	public int insertSellerAnswerInquiry(InquiryDTO dto) {
		return inquiryDAO.insertSellerAnswerInquiry(dto);
	}

	public int updateSellerMember(MemberDTO dto) {
		return sellerDAO.updateSellerMember(dto);
	}
	
}
