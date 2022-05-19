package com.banabook.web.domain.mylist.repository;

import java.util.List;

import com.banabook.web.domain.mylist.domain.MylistDTO;

public interface MylistDAO {
	//tb_mylist에 일반회원(아이디)이 담은 장바구니 상품 정보들 조회
	public List<MylistDTO> selectCartMylistToId(String id);
	//tb_mylist에 상품코드에 해당하는 레코드만 삭제
	public int deleteMylistToCode(String code);
	//tb_mylist에 회원에 해당하는 모든 레코드 삭제(FK때문에 회원탈퇴 시 실행해줘야 함)
	public int deleteMylistToId(String id);
	//tb_mylist에 장바구니 담기
	public int insertMylistCart(String id);
	//tb_mylist에 바로 주문하기(결제는 안함)
	public int insertMylistOrder(MylistDTO dto);
	//tb_mylist에 바로 주문하는데 결제를 곁들인
	public int insertMylistOrderPay(MylistDTO dto);
	//tb_mylist에 장바구니에서 주문으로 변경
	public int updateMylistCartToOrder(String mylist_id);
	//tb_mylist에 장바구니에서 주문으로 변경 그런데 결제를 곁들인
	public int updateMylistCartToOrderPay(String mylist_id);
	//tb_mylist에 데이터 중 구분(sort) 상태를 배송완료(50)으로 변경(판매자가 변경해줄듯)
	public int updateMylistShipped(String mylist_id);
	//tb_mylist에 데이터 중 구분(sort) 상태를 배송중(40)으로 변경(판매자가 변경해줄듯)
	public int updateMylistShipping(String mylist_id);
	//tb_mylist에 수량(amount) 변경
	public int updateMylistAmount(MylistDTO dto);
}
