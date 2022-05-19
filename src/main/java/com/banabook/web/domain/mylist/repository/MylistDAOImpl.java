package com.banabook.web.domain.mylist.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banabook.web.domain.mylist.domain.MylistDTO;
@Repository
public class MylistDAOImpl implements MylistDAO {
	
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<MylistDTO> selectCartMylistToId(String id) {
		return sqlSession.selectList("mapper.mylist.selectCartMylistToId", id);
	}

	@Override
	public int deleteMylistToCode(String code) {
		return sqlSession.delete("mapper.mylist.deleteMylistToCode", code);
	}

	@Override
	public int deleteMylistToId(String id) {
		return sqlSession.delete("mapper.mylist.deleteMylistToId", id);
	}

	@Override
	public int insertMylistCart(String id) {
		return sqlSession.insert("mapper.mylist.insertMylistCart", id);
	}

	@Override
	public int insertMylistOrder(MylistDTO dto) {
		return sqlSession.insert("mapper.mylist.insertMylistOrder", dto);
	}

	@Override
	public int insertMylistOrderPay(MylistDTO dto) {
		return sqlSession.insert("mapper.mylist.insertMylistOrderPay", dto);
	}

	@Override
	public int updateMylistCartToOrder(String mylist_id) {
		return sqlSession.update("mapper.mylist.updateMylistCartToOrder", mylist_id);
	}

	@Override
	public int updateMylistCartToOrderPay(String mylist_id) {
		return sqlSession.update("mapper.mylist.updateMylistCartToOrderPay", mylist_id);
	}

	@Override
	public int updateMylistShipped(String mylist_id) {
		return sqlSession.update("mapper.mylist.updateMylistShipped", mylist_id);
	}

	@Override
	public int updateMylistShipping(String mylist_id) {
		return sqlSession.update("mapper.mylist.updateMylistShipping", mylist_id);
	}

	@Override
	public int updateMylistAmount(MylistDTO dto) {
		return sqlSession.update("mapper.mylist.updateMylistAmount", dto);
	}

}
