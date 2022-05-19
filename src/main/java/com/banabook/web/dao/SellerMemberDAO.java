package com.banabook.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.banabook.web.dto.MemberDTO;

public interface SellerMemberDAO {
	
	 /* Seller 회원 조회 - 페이징 처리 미포함 */
	 public List<MemberDTO> selectAllSellerInfo() throws DataAccessException;
	
	 /* Seller 회원 조회 - 페이징 처리 포함 */
	 public List<MemberDTO> selectAllSellerInfoPaging(MemberDTO dto) throws DataAccessException;

	 /* Seller 회원 추가 - Sel 회원가입 / 기존 Info -> Member로 수정 */
	 public int insertSellerMember(MemberDTO dto) throws DataAccessException;
	 
	 /* Seller 회원 회원정보 수정 */
	 public int updateSellerMember(MemberDTO dto) throws DataAccessException;
}