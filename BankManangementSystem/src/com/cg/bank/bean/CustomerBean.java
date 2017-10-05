package com.cg.bank.bean;

public class CustomerBean {
	
	
	
	
	private int consumerId;
	private String customerName;
	private String phoneNo;
	private String password;
	private String re_password;
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRe_password() {
		return re_password;
	}
	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}
	
	public CustomerBean(String customerName, String phoneNo, String password,
			String re_password) {
		super();
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.password = password;
		this.re_password = re_password;
	}
	public CustomerBean(int consumerId, String customerName, String phoneNo,
			String password, String re_password) {
		super();
		this.consumerId = consumerId;
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.password = password;
		this.re_password = re_password;
	}
	public CustomerBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "CustomerBean [consumerId=" + consumerId + ", customerName="
				+ customerName + ", phoneNo=" + phoneNo + ", password="
				+ password + ", re_password=" + re_password + "]";
	}

}
