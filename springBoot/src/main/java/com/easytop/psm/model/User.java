package com.easytop.psm.model;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date age;
	private String sex;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, Date age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
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

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}


}
