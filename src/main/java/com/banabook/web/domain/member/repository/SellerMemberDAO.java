package com.banabook.web.domain.member.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.member.domain.MemberDTO;

public interface SellerMemberDAO {
	
	 /* Seller ȸ�� ��ȸ - ����¡ ó�� ������ */
	 public List<MemberDTO> selectAllSellerInfo() throws DataAccessException;
	
	 /* Seller ȸ�� ��ȸ - ����¡ ó�� ���� */
	 public List<MemberDTO> selectAllSellerInfoPaging(MemberDTO dto) throws DataAccessException;

	 /* Seller ȸ�� �߰� - Sel ȸ������ / ���� Info -> Member�� ���� */
	 public int insertSellerMember(MemberDTO dto) throws DataAccessException;
	 
	 /* Seller ȸ�� ȸ������ ���� */
	 public int updateSellerMember(MemberDTO dto) throws DataAccessException;
}