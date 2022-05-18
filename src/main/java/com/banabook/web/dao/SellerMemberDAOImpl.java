package com.banabook.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.banabook.web.dto.MemberDTO;

@Repository
public class SellerMemberDAOImpl implements SellerMemberDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override								//()�� ��������� �Ű������� ����
	public List<MemberDTO> selectAllSellerInfo() throws DataAccessException {			// �Ű����� ����� ��
	 	List<MemberDTO> result = sqlSession.selectList("mapper.SellerMember.selectAllSellerInfo");
	 	return result;							//namespace������ id���� ������� ã�ư�
	}

	@Override								
	public List<MemberDTO> selectAllSellerInfo(Map sellerPageInfo) throws DataAccessException {			
	 	List<MemberDTO> result = sqlSession.selectList("mapper.SellerMember.selectAllSellerInfo", sellerPageInfo);
	 	return result;						
	}

	@Override
	public int insertSellerMember(MemberDTO dto) throws DataAccessException {
		int result = sqlSession.update("mapper.SellerMember.insertSellerMember", dto);
		return result;
	}

	@Override								
	public int updateSellerMember(MemberDTO dto) throws DataAccessException {			
 	int result = sqlSession.update("mapper.SellerMember.updateSellerMember", dto);
 	return result;						
	}

}
