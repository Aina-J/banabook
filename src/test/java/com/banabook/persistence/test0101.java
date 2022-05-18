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

import com.banabook.web.dao.ProductDAO;
import com.banabook.web.dto.ProductDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
public class test0101 {

	@Autowired
	ProductDAO dao;
	
	@Test
	public void dbConn() {
		List<ProductDTO> list =  dao.selectAllProduct();
		assertThat(list.size(), is(10));
	}
	
	@Test
	public void getCodeProduct() {
		List<ProductDTO> list =  dao.selectCodeProduct("novel");
		assertThat(list.size(), is(2));
	}
}