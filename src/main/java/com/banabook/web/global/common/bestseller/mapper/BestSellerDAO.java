package com.banabook.web.global.common.bestseller.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.banabook.web.global.common.bestseller.domain.BestSellerDTO;

	@Repository
	public interface BestSellerDAO {
		
	//베스트셀러 리스트 뽑기
	public List<BestSellerDTO> selectBestSeller() throws DataAccessException;
	
}
