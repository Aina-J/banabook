package com.banabook.web.domain.product.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.service.ProductService;
import com.banabook.web.global.config.aop.LoginCheck;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	/* 해당 카테고리 상품목록에서 상품상세페이지로 이동 */
	@LoginCheck
	@RequestMapping(value="/product/list", method=RequestMethod.GET)
	public String productList(Model model,
			@RequestParam("code") String code
			) {
		logger.info("ProductController > productList() 호출");
		ProductDTO dto = productService.selectCodeProductOne(code);
		
		model.addAttribute("dto", dto);
		
		return "detail.view";
	}

}
