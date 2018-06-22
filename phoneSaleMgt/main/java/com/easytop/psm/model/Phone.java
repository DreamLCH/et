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
 *
 *手机对象实例类
 */
public class Phone {
	
	//手机id（唯一）
	private int id;
	
	//手机型号（唯一）
	@NotEmpty
	private String type;
	
	//手机品牌
	@NotEmpty
	private String brand;
	
	//手机价格
	@Min(value=1)
	private String price;
	
	//手机颜色
	@NotEmpty
	private String colour;
	
	//手机尺寸大小
	@NotEmpty
	private String size;
	
	//发布日期
	@Past
	private Date date;
	
	//关于手机描述
	@NotEmpty
	private String describe;
	
	
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Phone(int id, String type, String brand, String price, String colour, String size, Date date, String describe) {
		super();
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.price = price;
		this.colour = colour;
		this.size = size;
		this.date = date;
		this.describe = describe;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}


	@Override
	public String toString() {
		return "phone [type=" + type + ", brand=" + brand + ", price=" + price + ", colour=" + colour + ", size=" + size
				+ ", date=" + date + ", describe=" + describe + "]";
	}
	
	
}
