package com.banabook.web.domain.member.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.member.domain.MemberDTO;


public interface AdminMemberDAO {
	
	/* Seller ȸ��(����) ���� / ���� updateSellerInfo -> Approval(����)���� ����  */
	public int updateSellerAprvl(MemberDTO sellerDTO) throws DataAccessException;

}