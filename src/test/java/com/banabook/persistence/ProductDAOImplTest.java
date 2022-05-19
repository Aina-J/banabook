package com.banabook.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.repository.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
public class ProductDAOImplTest {

	@Autowired
	ProductDAO dao;

	@Test
	public void selectCodeProductTest() {
		List<ProductDTO> list = dao.selectCodeProduct("novel");
		assertThat(list.size(), is(2));
		list = dao.selectCodeProduct("");
		assertThat(list.size(), is(10));
	}

}
