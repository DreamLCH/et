package com.easytop.psm.dao;

import java.util.ArrayList;
import java.util.Map;

import com.easytop.psm.model.Retailer;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *销售商连接数据库接口，用于sql查询语句和add添加一个销售商
 */
public interface RetailerDao {
	
	/**
	 * 添加方法
	 * 
	 * @param retailer 销售商对象
	 */
	void addRetailer(Retailer retailer);
	
	
	/**
	 * 判断销售商名称是否存在
	 * 
	 * @param name 销售商名称
	 * @return	存在返回一个销售商对象，不存在返回null
	 */
	Retailer getRetailerByName(String name);
	
	
	/**
	 * 查询方法
	 * 
	 * 根据map里面传入的数据查询所有的销售商
	 * 
	 * @param map 用map装好的查询条件参数
	 * @return
	 */
	ArrayList queryAllRetailer(Map map);
	
	
	
	/**
	 * 查询方法
	 * 
	 * 查询销售商里面所有的区域
	 * @return
	 */
	ArrayList queryAllArea();
	
	
	/**
	 * 查询方法
	 * 
	 * 根据传入的销售商名称查询所对应的区域
	 * @param name	销售商名称
	 * @return
	 */
	String queryArea(String name);
}
