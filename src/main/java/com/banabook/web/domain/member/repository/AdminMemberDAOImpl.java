package com.banabook.web.domain.member.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.banabook.web.domain.member.domain.MemberDTO;

@Repository
public class AdminMemberDAOImpl implements AdminMemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int updateSellerAprvl(MemberDTO sellerDTO) throws DataAccessException {
		int result = sqlSession.update("mapper.adminMember", sellerDTO);
		return result;
	}
	
}