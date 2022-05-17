package com.banabook.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banabook.web.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> selectAdmin() {
		List<MemberDTO> list = sqlSession.selectList("com.banabook.web.dao.MemberDAO.selectAdmin");
		return list;
	}

}
