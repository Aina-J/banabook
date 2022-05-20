package com.banabook.web.domain.order.repository;

import java.util.List;

import com.banabook.web.domain.order.domain.OrderDTO;

public interface OrderDAO {
	List<OrderDTO> selectOrderInfo(String order_code);
}
