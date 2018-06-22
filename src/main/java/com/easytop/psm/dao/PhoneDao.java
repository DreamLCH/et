package com.easytop.psm.dao;

import java.util.ArrayList;
import java.util.Map;

import com.easytop.psm.model.Phone;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *手机连接数据库接口，用于sql查询语句和add添加手机
 *
 */
public interface PhoneDao {
	
	/**
	 * 添加方法
	 * 传入一个手机对象，然后添加到数据库手机表里
	 * @param phone 手机对象
	 */
	void add(Phone phone);
	
	
	/**
	 * 判断手机型号是否存在
	 * 传入一个手机型号，从数据库查询数据判断手机型号是否存在
	 * @param type	手机型号
	 * @return	存在返回Phone对象，不存在返回null。
	 */
	Phone getPhoneByType(String type);
	 
	
	/**
	 * 查询方法
	 * 根据传入的map为条件，查询所有手机信息
	 * @param map	用map装好的查询条件参数
	 * @return
	 */
	ArrayList queryAllPhone(Map map);
	 
	
	/**
	 * 查询方法
	 * 查询手机表里面所有的品牌
	 * @return
	 */
	ArrayList queryAllBrand();
	
	
	/**
	 * 查询方法
	 * 根据传入的手机品牌，查询品牌所对应的数据
	 * @param brand 手机品牌
	 * @return
	 */
	ArrayList queryAllData(Object brand);
	
	
}
