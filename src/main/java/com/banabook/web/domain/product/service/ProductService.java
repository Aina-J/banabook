package com.banabook.web.domain.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.repository.ProductDAO;
import com.banabook.web.global.config.aop.LoginCheck;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;
	
	@LoginCheck
	public List<ProductDTO> getProduct(){
		return productDAO.selectAllProduct();
	}
	
	// 코드에 해당하는 상품 정보 호출
	@LoginCheck
	public List<ProductDTO> selectCodeProduct(String code){
		return productDAO.selectCodeProduct(code);
	}
	
	// 코드에 해당하는 상품 정보 1개만 호출
	@LoginCheck
	public ProductDTO selectCodeProductOne(String code){
		return productDAO.selectCodeProductOne(code);
	}
}
