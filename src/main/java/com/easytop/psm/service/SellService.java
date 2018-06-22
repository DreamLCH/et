package com.easytop.psm.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easytop.psm.model.Sell;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *销售业务逻辑处理接口
 */

public interface SellService {

	
	/**
	 * 
	 * 添加方法
	 * 
	 * 把传入的销售对象添加到数据库
	 * 
	 * @param sell	销售对象
	 */
	Sell addSell(Sell sell);
	
	
	/**
	 * 查询方法
	 * 
	 * 调用queryAllSell方法查询
	 * 
	 * @param sell	销售商名称
	 * @param brand	手机品牌
	 * @param date	日期
	 * @param behavior	该参数用于区分用户点击的是上一页 或 下一页 或 首页 尾页 的操作
	 * @return
	 */
	ArrayList querySell(String sell, String brand, String date, String behavior);
	
	
	/**
	 * 查询方法
	 * 
	 * 查询销售表里所有的销售商名称
	 * @return
	 */
	ArrayList queryAllRetailer();
	
	
	/**
	 * 查询方法
	 * 
	 * 查询销售表里所有的手机品牌
	 * @return
	 */
	ArrayList queryAllBrand();
	
	
	/**
	 * 查询方法
	 * 
	 * 按照传入的参数查询销售信息
	 * 
	 * @param sell	销售商名称
	 * @param brand	手机品牌
	 * @param date	日期
	 * @return
	 */
	ArrayList queryAllSell(String sell, String brand, String date);
	
	
	
	/**
	 * 查询方法
	 * 
	 * 根据手机品牌和日期查询所有的手机型号
	 * 
	 * @param brand	手机品牌
	 * @param date	日期
	 * @return	返回所有查询到的手机型号
	 */
	ArrayList queryPhoneType(String brand,String date);
	
	
	/**
	 * 查询方法
	 * 
	 * 遍历ArrayList集合，然后获得集合里所有手机型号，再查询每个手机型号和年份1-12月份的销售量
	 * 
	 * @param list	ArrayList集合，储存着手机多个手机型号
	 * @param date	日期（年）
	 * @return
	 */
	Map queryTypeNumber(ArrayList list,String date);
	
	
	/**
	 * 
	 * 根据年份查询每个销售商1-12月的销售量
	 * 
	 * @param year	日期（年）
	 * @param behavior	该参数用于区分用户点击的是上一页 或 下一页 或 首页 尾页 的操作
	 * @return
	 */
	ArrayList querySalesVolume(String year,String behavior);
	
	
	
	/**
	 * 根据年份查询每个区域1-12月的销售量
	 * 
	 * @param year	日期（年）
	 * @param behavior	该参数用于区分用户点击的是上一页 或 下一页 或 首页 尾页 的操作
	 * @return
	 */
	ArrayList queryAllArea(String year, String behavior);
	
	
	/**
	 * 查询方法
	 * 
	 * 遍历ArrayList集合，获取集合里所有的手机品牌，再查询每个手机品牌的1-12月的销售量
	 * 
	 * @param list	ArrayList集合，储存着多个手机品牌
	 * @return
	 */
	ArrayList queryAllNum(ArrayList list);

}
