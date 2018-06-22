package com.easytop.psm.service;

import java.util.ArrayList;
import java.util.Map;

import com.easytop.psm.model.Phone;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *	业务接口对数据进行预处理（）
 *	调用DAO 数据访问层，将数据保存到RDMS 中去
 */
public interface PhoneService {

	/**
	 * 添加方法
	 * 传入一个手机对象，然后添加到数据库手机表里
	 * @param phone 手机对象
	 */
	Phone add(Phone phone);
	
	
	/**
	 * 判断手机型号是否存在
	 * 传入一个手机型号，从数据库查询数据判断手机型号是否存在
	 * @param type	手机型号
	 * @return	存在返回Phone对象，不存在返回null。
	 */
	Phone getPhoneByType(String type);
	
	
	/**
	 * 删除手机信息
	 * 
	 * @param id
	 *            手机id
	 */
	void deletePhone(int id);


	/**
	 * 查询所有手机数据
	 * 
	 * @param search
	 *            搜索参数
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            显示几条数据
	 * @return
	 */
	ArrayList queryAllPhone(String search, int offset, int limit);
	
	
	/**
	 * 查询总记录数
	 * 
	 * @param search
	 *            搜索参数
	 * @return
	 */
	int queryAllRecord(String search);
	
	/**
	 * 查询方法
	 * 查询手机表里面所有的品牌
	 * @return
	 */
	ArrayList queryAllBrand();
	
	
	/**
	 * 查询方法
	 * 
	 * 从传入的ArrayList遍历得到list里的所有手机品牌，再查询每个品牌所对应的手机数据
	 * @param list 储存着所有手机品牌
	 * @return
	 */
	Map queryAllData(ArrayList list);
	

}
