package com.banabook.web.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.dao.MemberDAO;
import com.banabook.web.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	public List<MemberDTO> getAdmin(){
		return memberDAO.selectAdmin();
	}
}
