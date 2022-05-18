package com.banabook.web.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banabook.web.dto.ProductDTO;
import com.banabook.web.service.ProductService;

@Controller
@RequestMapping("/temp")
public class ProductControllerTemp {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value ="/list_page", method=RequestMethod.GET)
	protected String view8(Model model) {
		List<ProductDTO> productList = productService.selectAllProduct();
		model.addAttribute("productList", productList);
		return "list_page.view";
	}
}
