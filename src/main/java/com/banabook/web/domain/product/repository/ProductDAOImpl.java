 package com.banabook.web.domain.product.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.banabook.web.domain.product.domain.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> selectAllProduct() throws DataAccessException {
		return sqlSession.selectList("mapper.product.selectAllProduct");
	}

	@Override
	public List<ProductDTO> selectCodeProduct(String code) throws DataAccessException {
		return sqlSession.selectList("mapper.product.selectCodeProduct", code);
	}

	@Override
	public ProductDTO selectCodeProductOne(String code) throws DataAccessException {
		return sqlSession.selectOne("mapper.product.selectCodeProduct", code);
	}
	
	@Override
	public List<ProductDTO> selectCodePageProduct(Map productPageInfo) throws DataAccessException {
		return sqlSession.selectList("mapper.product.selectCodePageProduct", productPageInfo);
	}

	@Override
	public List<ProductDTO> selectSellerPageProduct(Map sellerProductPageInfo) throws DataAccessException {
		return sqlSession.selectList("mapper.product.selectSellerPageProduct", sellerProductPageInfo);
	}

	@Override
	public List<ProductDTO> selectSellerProduct(String id) throws DataAccessException {
		return sqlSession.selectList("mapper.product.selectSellerProduct", id);
	}

	@Override
	public int deleteProduct(String code) throws DataAccessException {
		return sqlSession.delete("mapper.product.deleteProduct", code);
	}

	@Override
	public int updateProduct(ProductDTO dto) throws DataAccessException {
		return sqlSession.update("mapper.product.updateProduct", dto);
	}

	@Override
	public int insertProduct(ProductDTO dto) throws DataAccessException {
		return sqlSession.insert("mapper.product.insertProduct", dto);
	}
}
