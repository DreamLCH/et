package com.easytop.psm.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

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
	 * 查询方法
	 * 
	 * 根据参数查询所有的销售商
	 * 
	 * @param keyword	销售商名称关键字
	 * @param area		区域
	 * @return
	 */
	ArrayList queryAllRetailer(String keyword, String area);
	
	
	/**
	 * 查询方法
	 * 
	 * 调用queryAllRetailer方法
	 * @param keyword	销售商名称关键字
	 * @param area		区域
	 * @param behavior	该参数用于区分用户点击的是上一页 或 下一页 或 首页 尾页 的操作
	 * @return
	 */
	ArrayList queryRetailer(String keyword, String area,String behavior);
	
	
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
