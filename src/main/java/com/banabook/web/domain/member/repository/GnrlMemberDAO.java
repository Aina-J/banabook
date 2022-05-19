package com.banabook.web.domain.member.repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.member.domain.MemberDTO;

public interface GnrlMemberDAO {

	
	 /* �Ϲ� ȸ�� ��ȸ - ����¡ ó�� ������ */
	 public List<MemberDTO> selectAllGnrlMemInfo() throws DataAccessException;
	
	 /* �Ϲ� ȸ�� ��ȸ - ����¡ ó�� ���� */					
	 
	 public List<MemberDTO> selectAllGnrlMemInfoPaging(MemberDTO dto)  throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� �߰� - Gnrl ȸ������ / ���� insertInfo -> insertMember�� ���� */
	 public int insertMember(MemberDTO dto) throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� ���Խ� ID �ߺ� üũ */
	 public MemberDTO selectMemberID(String id) throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� ID�� �̱� */
	 public MemberDTO selectMemberToID(String id) throws DataAccessException;
	 
	 /* �Ϲ� ȸ�� ȸ������ ���� */
	 public int updateMember(MemberDTO dto) throws DataAccessException;

	 
	 /* ��� ȸ��(�Ϲ�+����) �α��� */			//DTO�� ����ȭ�Ǿ��־(�̹� ��ӵǾ��־) �� ���ϴ�			
	 public List<MemberDTO> selectAllLogin(MemberDTO dto) throws DataAccessException;		
	// DTO�� �ִ� ���� ���� ���� ���� ���̸� Map�� ����ؾ������� �װ� �ƴ϶�� DTO�� �ְ� �ް� ��°� �� ����
	 
	 /* ��� ȸ��(�Ϲ�+����) ��ȸ */
	 public List<MemberDTO> selectAllInfo(MemberDTO dto) throws DataAccessException;
	
	 /* ��� ȸ��(�Ϲ�+����) ���� - ���� Ȱ��ȭ/��Ȱ��ȭ  */ 
	 public int updateAllMemActv (String id) throws DataAccessException;

	 /* ��� ȸ��(�Ϲ�+����) ���� - ȸ�� ���� ����  */ 
	 public int deleteAllMember(String id) throws DataAccessException;

	
}




