package com.banabook.web.domain.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.repository.AdminMemberDAO;

@Service
public class AdminMemberService {
	
	@Autowired
	AdminMemberDAO adminDAO;
	
	public int updateSellerAprvl(MemberDTO dto) {
		return adminDAO.updateSellerAprvl(dto);
	}
	
	
	public List<MemberDTO> selectAllSellerInfo() {
		return adminDAO.selectAllSellerInfo();
	}

}
