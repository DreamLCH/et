package com.easytop.psm.model;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *管理员对象实例类
 */
public class User {
	
	//用户名称
	private String name;
	
	//用户密码
	private String password;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	
	
}
