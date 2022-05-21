package com.banabook.web.domain.member.domain;

public class MemberDTO {
	private String id;			// 회원아이디(일반회원, 판매자회원, 관리자)
	private int authority_id;	// 권한아이디(일반회원, 판매자회원, 관리자)
	private String password;	// 비밀번호(일반회원, 판매자회원, 관리자)
	private String birth;			// 생년월일(일반회원, 판매자회원, 관리자)
	private String name;		// 회원 이름(일반회원,관리자), 대표자명(판매자회원)
	private String tel;			// 전화번호(일반회원, 판매자회원, 관리자)
	private String address;		// 주소(일반회원, 판매자회원, 관리자)
	private String com_name;	// 회사명(판매자회원, 관리자)
	private String cr_no;		// 사업자번호(판매자회원, 관리자)
	private Integer entry;		// 입점승인(판매자회원)
	private int activation;		// 활성화(일반회원, 판매자회원, 관리자)
	public MemberDTO() {
	}
	public MemberDTO(String id, int authority_id, String password, String birth, String name, String tel, String address,
			String com_name, String cr_no, Integer entry, Integer activation) {
		this.id = id;
		this.authority_id = authority_id;
		this.password = password;
		this.birth = birth;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.com_name = com_name;
		this.cr_no = cr_no;
		this.entry = entry;
		this.activation = activation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCr_no() {
		return cr_no;
	}
	public void setCr_no(String cr_no) {
		this.cr_no = cr_no;
	}
	public Integer getEntry() {
		return entry;
	}
	public void setEntry(Integer entry) {
		this.entry = entry;
	}
	public Integer getActivation() {
		return activation;
	}
	public void setActivation(Integer activation) {
		this.activation = activation;
	}
}
