package com.banabook.web.domain.order.domain;

import java.sql.Date;

public class OrderDTO {
	private String order_code;
	private String orderer;
	private Date order_date;
	private String receiver;
	private String receiver_tel;
	private String shipping_address;
	//join할 때 필요
	private String mylist_id;
	private String id;
	private String code;
	private int sort;
	private int amount;
	private String seller_id;
	private String product_name;
	private int price;
	private String sort_name;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(String order_code, String orderer, Date order_date, String receiver, String receiver_tel,
			String shipping_address, String mylist_id, String id, String code, int sort, int amount, String seller_id,
			String product_name, int price, String sort_name) {
		super();
		this.order_code = order_code;
		this.orderer = orderer;
		this.order_date = order_date;
		this.receiver = receiver;
		this.receiver_tel = receiver_tel;
		this.shipping_address = shipping_address;
		this.mylist_id = mylist_id;
		this.id = id;
		this.code = code;
		this.sort = sort;
		this.amount = amount;
		this.seller_id = seller_id;
		this.product_name = product_name;
		this.price = price;
		this.sort_name = sort_name;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getOrderer() {
		return orderer;
	}
	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiver_tel() {
		return receiver_tel;
	}
	public void setReceiver_tel(String receiver_tel) {
		this.receiver_tel = receiver_tel;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
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
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
}
