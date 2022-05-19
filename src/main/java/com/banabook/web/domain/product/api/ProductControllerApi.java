package com.banabook.web.domain.product.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.service.ProductService;

@RestController
public class ProductControllerApi {

	@Autowired
	ProductService service;

	@RequestMapping(value="/main/{category}", method=RequestMethod.GET)
	public List<ProductDTO> goListPage(
			Model model
			,@PathVariable("category") String category
			) {
		List<ProductDTO> productList = service.selectCodeProduct(category);
		
		return productList;
	}

}
