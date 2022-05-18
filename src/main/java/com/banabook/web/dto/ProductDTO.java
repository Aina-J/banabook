package com.banabook.web.dto;

public class ProductDTO {
	private String code;			//상품코드
	private String id;				//판매자 아이디
	private String name;			//상품명
	private int price;				//가격
	private String representative;	//대표이미지
	private String details;			//상세이미지
	private Integer like;			//상품 좋아요 수
	public ProductDTO() {
	}
	public ProductDTO(String code, String id, String name, int price, String representative, String details,
			Integer like) {
		this.code = code;
		this.id = id;
		this.name = name;
		this.price = price;
		this.representative = representative;
		this.details = details;
		this.like = like;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getLike() {
		return like;
	}
	public void setLike(Integer like) {
		this.like = like;
	}
}
