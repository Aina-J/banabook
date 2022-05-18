package com.banabook.web.dao;

import java.util.List;

import com.banabook.web.dto.MemberDTO;

public interface MemberDAO {
	
	public List<MemberDTO> selectAdmin();
}
