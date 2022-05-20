package com.banabook.web.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.member.domain.MemberDTO;
import com.banabook.web.domain.member.repository.GnrlMemberDAO;

@Service
public class GnrlMemberService {
	
	@Autowired
	GnrlMemberDAO memberDAO;
	
	public int insertMember(MemberDTO memberDTO) {
		int result = memberDAO.insertMember(memberDTO);
		return result;
	}

	public MemberDTO isIdUnique(String id) {
		return memberDAO.selectMemberID(id);
	}

}
