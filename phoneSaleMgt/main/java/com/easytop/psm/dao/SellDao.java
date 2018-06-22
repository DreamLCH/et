package com.easytop.psm.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.easytop.psm.model.Sell;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *销售信息连接数据库接口，用于sql查询语句和add录入销售信息
 *
 */
public interface SellDao {

	/**
	 * 
	 * 添加方法
	 * 
	 * 把传入的销售对象添加到数据库
	 * 
	 * @param sell	销售对象
	 */
	void addSell(Sell sell);
	
	
	/**
	 * 删除销售信息
	 * 
	 * @param id
	 *            销售id
	 */
	void deleteSell(int id);


	/**
	 * 查询方法
	 * 
	 * 查询销售表里所有的销售商名称
	 * 
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
	 * 根据传入的map为条件查询销售数据
	 * 
	 * @param map
	 *            用map装好的查询条件参数
	 * @return
	 */
	ArrayList querySellData(Map map);

	/**
	 * 查询总记录数
	 * 
	 * @param search
	 *            搜索参数
	 * @return
	 */
	int queryAllRecord(@Param("search") String search);

	/**
	 * 查询方法
	 * 
	 * 根据传入的map为条件查询销售数据
	 * 
	 * @param map	用map装好的查询条件参数
	 * @return
	 */
	ArrayList queryAllSell(Map map);
	
	
	/**
	 * 查询按品牌统计总记录数
	 * 
	 * @param map
	 *            查询条件
	 * @return
	 */
	int queryAllSellRecord(Map map);

	/**
	 * 查询方法
	 * 
	 * 根据手机品牌和日期查询所有的手机型号
	 * 
	 * @param brand	手机品牌
	 * @param date	日期
	 * @return	返回所有查询到的手机型号
	 */
	ArrayList queryPhoneType(@Param("brand")String brand,@Param("date")String date);
	
	
	/**
	 * 查询方法
	 * 
	 * 根据手机型号和年份查询1-12月份的销售量
	 * 
	 * @param type	手机型号
	 * @param date	日期（年）
	 * @return
	 */
	ArrayList queryTypeNumber(@Param("type") Object type, @Param("date") String date);
	
	
	/**
	 * 
	 * 根据年份查询每个销售商1-12月的销售量
	 * 
	 * @param year	日期（年）
	 * @return
	 */
	ArrayList querySalesVolume(Map map);
	
	
	/**
	 * 查询按销售商统计总记录数
	 * 
	 * @param year
	 * @return
	 */
	int queryAllRetailerRecord(String year);


	/**
	 * 根据年份查询每个区域1-12月的销售量
	 * 
	 * @param year	日期（年）
	 * @return
	 */
	ArrayList queryAllArea(Map map);
	
	
	/**
	 * 查询按区域统计总记录数
	 * 
	 * @param year
	 * @return
	 */
	int queryAllAreaRecord(String year);

	/**
	 * 查询方法
	 * 
	 * 查询传入的手机品牌1-12月的销售量
	 * 
	 * @param brand
	 *            手机品牌
	 * @return
	 */
	ArrayList queryAllNum(@Param("brand") String brand, @Param("year") String year);
	
}
