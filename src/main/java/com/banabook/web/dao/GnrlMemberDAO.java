package com.banabook.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import com.banabook.web.dto.MemberDTO;

public interface GnrlMemberDAO {

		
	 /* �Ϲ� ȸ�� ��ȸ - ����¡ ó�� ������ */
	 public List<MemberDTO> selectAllGnrlMemInfo() throws DataAccessException;
	
	 /* �Ϲ� ȸ�� ��ȸ - ����¡ ó�� ���� */
	 public List<MemberDTO> selectAllGnrlMemInfoPaging(Map gnrMemPageInfo)  throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� �߰� - Gnrl ȸ������ / ���� insertInfo -> insertMember�� ���� */
	 public int insertMember(MemberDTO dto) throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� ���Խ� ID �ߺ� üũ */
	 public String selectMemberID(String id) throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� ID�� �̱� */
	 public MemberDTO selectMemberToID(String id) throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� ȸ������ ���� */
	 public int updateMember(MemberDTO dto) throws DataAccessException;

	 
	 /* ��� ȸ��(�Ϲ�+����) �α��� */							
	 public List<MemberDTO> selectAllLogin(String id, String password) throws DataAccessException;		
	 
	 /* ��� ȸ��(�Ϲ�+����) ��ȸ */
	 public MemberDTO selectAllInfo(String id, String password) throws DataAccessException;
	
	 /* ��� ȸ��(�Ϲ�+����) ���� - ���� Ȱ��ȭ/��Ȱ��ȭ  */ 
	 public int updateAllMemActv (String id) throws DataAccessException;

	 /* ��� ȸ��(�Ϲ�+����) ���� - ȸ�� ���� ����  */ 
	 public int deleteAllMember(String id) throws DataAccessException;

	
}




