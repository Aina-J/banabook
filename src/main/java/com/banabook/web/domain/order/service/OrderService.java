package com.banabook.web.domain.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.order.domain.OrderDTO;
import com.banabook.web.domain.order.repository.OrderDAO;

@Service
public class OrderService {
	@Autowired
	OrderDAO dao;
	
	public List<OrderDTO> getOrderInfo(String order_code) {
		return dao.selectOrderInfo(order_code);
	}
}
