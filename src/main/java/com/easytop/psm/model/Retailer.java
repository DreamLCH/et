package com.easytop.psm.model;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *销售商对象实例类
 */
public class Retailer {
	
	//销售商id（唯一）
	private int id;
	
	//销售商名称（唯一）
	private String name;
	
	//销售商区域
	private String area;
	
	//销售商负责人
	private String principal;
	
	//负责人联系电话
	private String phone;
	
	//身份证号码
	private String identity;
	
	//联系地址
	private String address;
	
	//邮编号码
	private String postcode;
	
	
	public Retailer() {
		super();
	}


	public Retailer(int id,String name, String area, String principal, String phone, String identity, String address,
			String postcode) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.principal = principal;
		this.phone = phone;
		this.identity = identity;
		this.address = address;
		this.postcode = postcode;
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getPrincipal() {
		return principal;
	}


	public void setPrincipal(String principal) {
		this.principal = principal;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	@Override
	public String toString() {
		return "retailer [name=" + name + ", area=" + area + ", principal=" + principal + ", phone=" + phone
				+ ", identity=" + identity + ", address=" + address + ", postcode=" + postcode + "]";
	}
	
	
}
