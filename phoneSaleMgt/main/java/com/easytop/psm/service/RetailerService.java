package com.easytop.psm.service;

import java.util.ArrayList;
import java.util.Map;

/**
 * 销售商业务逻辑处理接口
 * 
 */

import com.easytop.psm.model.Retailer;
import com.easytop.psm.model.Sell;

public interface RetailerService {
	
	/**
	 * 添加方法
	 * 
	 * @param retailer 销售商对象
	 */
	Retailer addRetailer(Retailer retailer);
	
	
	/**
	 * 判断销售商名称是否存在
	 * 
	 * @param name 销售商名称
	 * @return	存在返回一个销售商对象，不存在返回null
	 */
	Retailer getRetailerByName(String name);
	
	
	/**
	 * 查询所有手机数据
	 * 删除销售商信息
	 * 
	 * @param id
	 *            销售商id
	 */
	void deleteRetailer(int id);

	/**
	 * 查询方法
	 * 
	 * @param search
	 *            搜索参数
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            显示几条数据
	 * @return
	 */
	ArrayList queryAllRetailer(String search, int offset, int limit);
	
	
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
	 * 
	 * 查询销售商里面所有的区域
	 * @return
	 */
	ArrayList queryAllArea();
	
	
	
	/**
	 * 查询方法
	 * 
	 * 遍历传入的ArrayList<Sell>集合，获取所有销售对象，再查询每个销售对象对应的区域
	 * @param list	ArrayList<Sell>集合，储存着销售对象
	 * @return
	 */
	Map queryArea(ArrayList<Sell> list);
}
