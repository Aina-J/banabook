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

import com.banabook.web.domain.review.domain.ReviewDTO;
import com.banabook.web.domain.review.mapper.ReviewDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class ReviewTest {

	@Autowired
	ReviewDAO dao;
	
	@Test
	public void dbConn() {
		List<ReviewDTO> list = dao.selectReviewList("novel_1");
		assertThat(list.size(), is(1));
	}
	
}