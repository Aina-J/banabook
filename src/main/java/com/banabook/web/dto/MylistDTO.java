package com.banabook.web.dto;

public class MylistDTO {
	private String mylist_id;	//마이리스트 아이디
	private String id;			//일반회원 아이디
	private String code;		//상품코드
	private int sort;			//상품 상태 구분
	private String order_code;	//주문코드
	private int amount;			//상품 수량
	//DB 조인하면서 필요한 필드
	private String sort_name;	//상품 상태 구분 이름
	private String product_name;//상품명
	private int price;			//가격
	private String authority_id;//회원권한 아이디
	public MylistDTO() {
	}
	public MylistDTO(String mylist_id, String id, String code, int sort, String order_code, int amount,
			String sort_name, String product_name, int price, String authority_id) {
		this.mylist_id = mylist_id;
		this.id = id;
		this.code = code;
		this.sort = sort;
		this.order_code = order_code;
		this.amount = amount;
		this.sort_name = sort_name;
		this.product_name = product_name;
		this.price = price;
		this.authority_id = authority_id;
	}
	public String getMylist_id() {
		return mylist_id;
	}
	public void setMylist_id(String mylist_id) {
		this.mylist_id = mylist_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(String authority_id) {
		this.authority_id = authority_id;
	}
}
