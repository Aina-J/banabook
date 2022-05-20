package com.banabook.web.domain.order.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banabook.web.domain.order.domain.OrderDTO;
@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<OrderDTO> selectOrderInfo(String order_code) {
		return sqlSession.selectList("mapper.order.selectOrderInfo", order_code);
	}

}
