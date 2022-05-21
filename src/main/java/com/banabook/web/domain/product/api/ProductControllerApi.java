package com.banabook.web.domain.product.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banabook.web.domain.product.domain.ProductDTO;
import com.banabook.web.domain.product.service.ProductService;
import com.banabook.web.global.common.Paging;

@RestController
@RequestMapping("/productApi")
public class ProductControllerApi {

	@Autowired
	ProductService service;

	@RequestMapping(value="/main/{category}", method=RequestMethod.GET)
	public Map goListPage(
			HttpServletRequest req
			,Model model
			,@PathVariable("category") String category
			) {
		List<ProductDTO> productList = service.selectCodeProduct(category);
		Paging paging = new Paging(productList.size());
		paging.paging(Integer.parseInt(req.getParameter("page")));
		
		List<ProductDTO> resultList = new ArrayList();
		for(int i = paging.getBeginRow() - 1; i < paging.getEndRow(); i++) {
			resultList.add(productList.get(i));
		}
		
		Map map = new HashMap();
		map.put("beginPage", paging.getBeginPage());
		map.put("endPage", paging.getEndPage());
		map.put("section", paging.getSection());
		map.put("next", paging.isNext());
		map.put("pre", paging.isPrev());
		map.put("data", resultList);
		
		return map;
	}

}
