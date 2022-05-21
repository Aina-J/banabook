package com.banabook.web.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.repository.SellerMemberDAO;

@Service
public class SellerMemberService {
	
	@Autowired
	SellerMemberDAO sellerDAO;
	
	public int insertSellerMember(MemberDTO dto) {
		return sellerDAO.insertSellerMember(dto);
	}

	public boolean isIdUnique(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
