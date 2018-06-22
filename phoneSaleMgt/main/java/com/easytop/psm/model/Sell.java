package com.easytop.psm.model;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *销售对象实例类
 */
public class Sell {
	
	//销售商名称
	@NotEmpty
	private String name;
	
	//手机品牌
	@NotEmpty
	private String brand;
	
	//手机型号
	@NotEmpty
	private String type;
	
	//销售日期
	@Past
	private Date date;
	
	//销售数量
	@Min(value = 1)
	private int number;
	
	
	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sell(String name, String brand, String type, Date date, int number) {
		super();
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.date = date;
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "Sell [name=" + name + ", brand=" + brand + ", type=" + type + ", date=" + date + ", number=" + number
				+ "]";
	}
	
	
	
}
