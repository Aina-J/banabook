package com.banabook.web.global.common.bestseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.global.common.bestseller.domain.BestSellerDTO;
import com.banabook.web.global.common.bestseller.mapper.BestSellerDAO;

@Service
public class BestSellerService {

	@Autowired
	BestSellerDAO bestSellerDAO;
	
	public List<BestSellerDTO> getBestSellerforMain() {
		return bestSellerDAO.selectBestSeller();
	}
}
