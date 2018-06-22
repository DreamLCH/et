package com.easytop.psm.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easytop.psm.model.Phone;
import com.easytop.psm.model.Sell;

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
	 * 查询方法
	 * 根据传入的map为条件，查询所有手机信息
	 * 
	 * @param keyword	手机型号关键字
	 * @param brand		手机品牌
	 * @param price1	价格区间（price1-price2价格之间）
	 * @param price2	价格区间
	 * @return
	 */
	ArrayList queryAllPhone(String keyword, String brand, String price1, String price2);
	
	
	/**
	 * 
	 * 查询方法
	 * 
	 * 调用queryAllPhone方法进行查询
	 * 
	 * @param keyword  手机型号关键字
	 * @param brand    手机品牌
	 * @param price1	价格区间（price1-price2价格之间）
	 * @param price2	价格区间
	 * @param behavior	该参数用于区分用户点击的是上一页 或 下一页 或 首页 尾页 的操作
	 * @return
	 */
	ArrayList queryPhone(String keyword, String brand, String price1, String price2, String behavior);
	
	
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
	
	
	/**
	 * 遍历传入的ArrayList<Sell>集合，查询每个手机型号所对应的手机尺寸大小
	 * 
	 * @param list	ArrayList<Sell>集合，里面存着销售对象
	 * @return
	 */
	ArrayList querySize(ArrayList<Sell> list);
	
}
