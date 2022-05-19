package com.banabook.web.domain.member.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.member.domain.MemberDTO;

public interface SellerMemberDAO {
	
	 /* Seller 회원 조회  */
	 public List<MemberDTO> selectAllSellerInfo() throws DataAccessException;
	
	 /* Seller 회원 추가 - Sel 회원가입 / 기존 Info -> Member로 수정 */
	 public int insertSellerMember(MemberDTO dto) throws DataAccessException;
	   
	 /* Seller 회원 회원정보 수정 */ 
	 public int updateSellerMember(MemberDTO dto) throws DataAccessException;
}