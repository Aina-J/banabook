package com.banabook.web.domain.member.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.banabook.web.domain.member.domain.MemberDTO;

@Repository
public class GnrlMemberDAOImpl implements GnrlMemberDAO {
	
	@Autowired
	private SqlSession sqlSession; 

	@Override							
	public List<MemberDTO> selectAllGnrlMemInfo() throws DataAccessException {			
		return sqlSession.selectList("mapper.GeneralMember.selectAllGnrlMemInfo");
	}

	@Override
	public int insertMember(MemberDTO dto) throws DataAccessException {
		return sqlSession.insert("mapper.GeneralMember.insertMember", dto);
	}

	@Override
	public MemberDTO selectMemberID(String id) throws DataAccessException {
		MemberDTO checkIdDupl  = sqlSession.selectOne("mapper.GeneralMember.selectMemberID", id);
		return checkIdDupl;
	}
	
	@Override
	public MemberDTO selectMemberToID(String id) throws DataAccessException {
		MemberDTO srchMembyId = sqlSession.selectOne("mapper.GeneralMember.selectMemberToID", id);
		return srchMembyId;
	}
	
	@Override
	public int updateMember(MemberDTO dto) throws DataAccessException {
		return sqlSession.update("mapper.GeneralMember.updateMember");
	}
	
	@Override								
	public List<MemberDTO> selectAllLogin(MemberDTO dto) throws DataAccessException {			
		return sqlSession.selectList("mapper.GeneralMember.selectAllLogin", dto);						
	}
	
	@Override								
	public MemberDTO selectAllInfo(MemberDTO dto) throws DataAccessException {			
		return (MemberDTO) sqlSession.selectList("mapper.GeneralMember.selectAllInfo", dto);						
	}
		
	@Override
	public int updateAllMemActv(String id) throws DataAccessException {
		return sqlSession.update("mapper.GeneralMember.updateAllMemActv", id);
	}
	
	@Override
	public int deleteAllMember(String id) throws DataAccessException {
		return sqlSession.delete("mapper.GeneralMember.deleteAllMember", id);
	}

}
