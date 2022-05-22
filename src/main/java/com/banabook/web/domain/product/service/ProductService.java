package com.banabook.web.domain.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.repository.ProductDAO;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	public List<ProductDTO> getProduct(){
		return productDAO.selectAllProduct();
	}
	
	// 코드에 해당하는 상품 정보 호출
	public List<ProductDTO> selectCodeProduct(String code){
		return productDAO.selectCodeProduct(code);
	}
	
	// 코드에 해당하는 상품 정보 1개만 호출
	public ProductDTO selectCodeProductOne(String code){
		return productDAO.selectCodeProductOne(code);
	}
	
	public int insertProduct(ProductDTO dto) {
		return productDAO.insertProduct(dto);
	}
}
