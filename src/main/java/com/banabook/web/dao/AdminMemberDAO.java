<<<<<<< HEAD
package com.banabook.web.dao.copy;
=======
package com.banabook.web.dao;
>>>>>>> 05d6f49e4d9fcfe2d568131d1273ade6f28f90e7

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.banabook.web.dto.MemberDTO;


public interface AdminMemberDAO {
	
	/* Seller ȸ��(����) ���� / ���� updateSellerInfo -> Approval(����)���� ����  */
	public int updateSellerAprvl(MemberDTO sellerDTO) throws DataAccessException;

}