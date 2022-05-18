package com.banabook.web.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.banabook.web.dto.MemberDTO;


public interface AdminMemberDAO {
	
	/* Seller ȸ��(����) ���� / ���� updateSellerInfo -> Approval(����)���� ����  */
	public int updateSellerAprvl(MemberDTO sellerDTO) throws DataAccessException;

}