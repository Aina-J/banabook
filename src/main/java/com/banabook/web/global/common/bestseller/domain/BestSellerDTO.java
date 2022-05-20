package com.banabook.web.global.common.bestseller.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BestSellerDTO {
	
	/* 상품 id */
	private String code;
	
	/* 상품 이름 */
	private String name;
	
	/* 상품 이름 */
	private int price;
	
	/* 상품 이미지 */
	private String representative;	
	
	public BestSellerDTO() {
	}
	
	public BestSellerDTO(String code, String name, int price, String representative) {
	      this.code = code;
	      this.name = name;
	      this.price = price;
	      this.representative = representative;
	}
	      
}
