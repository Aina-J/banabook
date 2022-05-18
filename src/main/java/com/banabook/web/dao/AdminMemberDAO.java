package com.banabook.web.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.banabook.web.dto.MemberDTO;


public interface AdminMemberDAO {
	
	/* Seller 회원(입점) 승인 / 기존 updateSellerInfo -> Approval(승인)으로 수정  */
	public int updateSellerAprvl(MemberDTO sellerDTO) throws DataAccessException;

}