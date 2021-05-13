package com.realcoderz.vo;

public class RegisterVO {
	private int loginId;
	private String name;
	private String address;
	private String email;
	private String mobile;
	private String addhar_card;
	private String password;

	// generate setter and getter
	
	public String getName() {
		return name;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddhar_card() {
		return addhar_card;
	}

	public void setAddhar_card(String addhar_card) {
		this.addhar_card = addhar_card;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}// class
