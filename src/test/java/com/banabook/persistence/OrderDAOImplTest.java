package com.banabook.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.banabook.web.domain.order.domain.OrderDTO;
import com.banabook.web.domain.order.repository.OrderDAO;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
public class OrderDAOImplTest {
	@Autowired
	OrderDAO dao;
	@Test
	public void testSelectOrderInfo() {
		List<OrderDTO> list = dao.selectOrderInfo("2022-01-12-1");
		assertThat(list.size(), is(2));
	}

}
