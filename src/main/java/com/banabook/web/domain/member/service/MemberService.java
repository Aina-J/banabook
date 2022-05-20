package com.banabook.web.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.repository.AdminMemberDAO;
import com.banabook.web.domain.member.repository.GnrlMemberDAO;
import com.banabook.web.domain.member.repository.SellerMemberDAO;

@Service
public class MemberService {

	@Autowired
	GnrlMemberDAO gmdao;
	@Autowired
	AdminMemberDAO admdao;
	@Autowired
	SellerMemberDAO smdao;
	public void insertMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
	}

	public boolean isIdUnique(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public MemberDTO getMemberInfoToid(String id) {
		return gmdao.selectMemberToID(id);
	}

}
