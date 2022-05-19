package com.banabook.web.domain.product.repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.banabook.web.domain.product.domain.ProductDTO;

public interface ProductDAO {
	//tb_product에 모든 데이터 조회
	public List<ProductDTO> selectAllProduct() throws DataAccessException;
	//tb_product에 특정 코드에 해당하는 데이터 조회
	public List<ProductDTO> selectCodeProduct(String code) throws DataAccessException;
	//tb_product에 특정 코드에 해당하는 데이터 하나만 조회
	public ProductDTO selectCodeProductOne(String code) throws DataAccessException;
	//tb_product에 특정 코드에 해당하는 데이터 조회 그런데 페이징을 곁들인
	public List<ProductDTO> selectCodePageProduct(Map productPageInfo) throws DataAccessException; //Map productPageInfo 에는 상품코드, 페이지 offset, 페이지 end 가 있어야 함
	//tb_product에 판매자가 파는 상품 데이터 조회 그런데 페이징을 곁들인
	public List<ProductDTO> selectSellerPageProduct(Map sellerProductPageInfo) throws DataAccessException; //Map sellerProductPageInfo 에는 판매자 아이디, 페이지 offset, 페이지 end 가 있어야 함
	//tb_product에 판매자가 파는 상품 몽땅 데이터 조회
	public List<ProductDTO> selectSellerProduct(String id) throws DataAccessException;
	//tb_product에 상품 데이터 삭제
	public int deleteProduct(String code) throws DataAccessException;
	//tb_product에 상품 데이터 수정
	public int updateProduct(ProductDTO dto) throws DataAccessException;
	//tb_product에 상품 데이터 삽입
	public int insertProduct(ProductDTO dto) throws DataAccessException;
}
