package com.banabook.web.domain.member.repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.member.domain.MemberDTO;

public interface GnrlMemberDAO {

	
	 /* 일반 회원 조회  */
	 public List<MemberDTO> selectAllGnrlMemInfo() throws DataAccessException;
	
	 /* 일반 회원 추가 - Gnrl 회원가입 / 기존 insertInfo -> insertMember로 수정 */					
	 public int insertMember(MemberDTO dto) throws DataAccessException;
	 
	 /* 일반 회원 가입시 ID 중복 체크 */
	 public MemberDTO selectMemberID(String id) throws DataAccessException;
	 
	 /* 일반 회원 ID로 뽑기 */
	 public MemberDTO selectMemberToID(String id) throws DataAccessException;
	 
	 /* 일반 회원 회원정보 수정 */
	 public int updateMember(MemberDTO dto) throws DataAccessException;
	 
	 /* 모든 회원(일반+셀러) 로그인 */			
	 public List<MemberDTO> selectAllLogin(MemberDTO dto) throws DataAccessException;	
	 
	 public MemberDTO selectAllInfo(MemberDTO dto) throws DataAccessException;
	
	 /* 모든 회원(일반+셀러) 관리 - 상태 활성화/비활성화  */ 
	 public int updateAllMemActv (String id) throws DataAccessException;

	 /* 모든 회원(일반+셀러) 삭제 - 회원 정보 삭제  */ 
	 public int deleteAllMember(String id) throws DataAccessException;
	
}