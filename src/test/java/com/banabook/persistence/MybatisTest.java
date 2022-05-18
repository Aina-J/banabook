package com.banabook.persistence;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {
	
	// SqlSessionFactory ��ü�� �ڵ����� �����մϴ�
	@Inject
	private SqlSessionFactory sqlFactory;
	
	// SqlSessionFactory ��ü�� ����� ����������� Ȯ��
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	// MyBatis�� DB ������ ����� ����Ǿ����� Ȯ��
	@Test
	public void testSession() throws Exception {
		try(SqlSession session = sqlFactory.openSession();
		Connection con = session.getConnection()) {
			System.out.println(session);
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
