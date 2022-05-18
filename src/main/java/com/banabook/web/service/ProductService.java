package com.banabook.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.dao.ProductDAO;
import com.banabook.web.dto.ProductDTO;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;
	
	public List<ProductDTO> getProduct(){
		return productDAO.selectAllProduct();
	}
}
