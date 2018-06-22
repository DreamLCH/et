package com.easytop.psm.model;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name;
	private String sex;
	private int age;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}
