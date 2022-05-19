package com.banabook.web.domain.member.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.member.domain.MemberDTO;


public interface AdminMemberDAO {
	
	/* Seller 회원(입점) 승인 / 기존 updateSellerInfo -> Approval(승인)으로 수정 */
	public int updateSellerAprvl(MemberDTO sellerDTO) throws DataAccessException;

}