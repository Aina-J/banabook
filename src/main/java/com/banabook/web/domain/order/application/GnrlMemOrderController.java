package com.banabook.web.domain.order.application;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banabook.web.domain.order.domain.OrderDTO;
import com.banabook.web.domain.order.service.OrderService;

@Controller
@RequestMapping("/memOrder")
public class GnrlMemOrderController {
	@Autowired
	OrderService service;
	
	@RequestMapping(value="/orderView", 
			method=RequestMethod.GET)
	public String orderView(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("id"));
		List<OrderDTO> orders = service.getOrderInfo(id);
		model.addAttribute("orders", orders);

		return "order.view";
	}
}
