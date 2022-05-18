package com.banabook.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.banabook.web.dto.MemberDTO;

public interface SellerMemberDAO {
	
	 /* Seller ȸ�� ��ȸ - ����¡ ó�� ������ */
	 public List<MemberDTO> selectAllSellerInfo() throws DataAccessException;
	
	 /* Seller ȸ�� ��ȸ - ����¡ ó�� ���� */
	 public List<MemberDTO> selectAllSellerInfo(Map sellerPageInfo) throws DataAccessException;

	 /* Seller ȸ�� �߰� - Sel ȸ������ / ���� Info -> Member�� ���� */
	 public int insertSellerMember(MemberDTO dto) throws DataAccessException;
	 
	 /* Seller ȸ�� ȸ������ ���� */
	 public int updateSellerMember(MemberDTO dto) throws DataAccessException;

<<<<<<< HEAD

=======
>>>>>>> 05d6f49e4d9fcfe2d568131d1273ade6f28f90e7
}