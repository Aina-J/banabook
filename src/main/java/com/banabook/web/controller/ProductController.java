package com.banabook.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.dto.ProductDTO;
import com.banabook.web.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/list_page", method = RequestMethod.GET)
	public String product(Model model) {
		
		List<ProductDTO> productList = productService.getProduct();
		model.addAttribute("productList", productList );
		
		return "list_page.view";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String productDetail(Model model, @RequestParam("code") String code ) {
		List<ProductDTO> productList = productService.selectCodeProduct(code);
		model.addAttribute("productList", productList );
		
		return "detail.view";
	}
}