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
		return sqlSession.selectList("mapper.gnrlMember.selectAllGnrlMemInfo");
	}

	@Override
	public int insertMember(MemberDTO dto) throws DataAccessException {
		return sqlSession.insert("mapper.gnrlMember.insertMember", dto);
	}

	@Override
	public MemberDTO selectMemberID(String id) throws DataAccessException {
		MemberDTO checkIdDupl  = sqlSession.selectOne("mapper.gnrlMember.selectMemberID", id);
		return checkIdDupl;
	}
	
	@Override
	public MemberDTO selectMemberToID(String id) throws DataAccessException {
		MemberDTO srchMembyId = sqlSession.selectOne("mapper.gnrlMember.selectMemberToID", id);
		return srchMembyId;
	}
	
	@Override
	public int updateMember(MemberDTO dto) throws DataAccessException {
		return sqlSession.update("mapper.gnrlMember.updateMember");
	}
	
	@Override								
	public List<MemberDTO> selectAllLogin(MemberDTO dto) throws DataAccessException {			
		return sqlSession.selectList("mapper.gnrlMember.selectAllLogin", dto);						
	}
	
	@Override								
	public MemberDTO selectAllInfo(MemberDTO dto) throws DataAccessException {			
		return (MemberDTO) sqlSession.selectList("mapper.gnrlMember.selectAllInfo", dto);						
	}
		
	@Override
	public int updateAllMemActv(String id) throws DataAccessException {
		return sqlSession.update("mapper.gnrlMember.updateAllMemActv", id);
	}
	
	@Override
	public int deleteAllMember(String id) throws DataAccessException {
		return sqlSession.delete("mapper.gnrlMember.deleteAllMember", id);
	}

}
