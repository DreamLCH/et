package com.easytop.psm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytop.psm.dao.SellDao;
import com.easytop.psm.model.Sell;
import com.easytop.psm.service.SellService;
import com.easytop.psm.utils.Paging;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 * 
 *销售业务逻辑处理类，用于调用dao层接口里的方法来连接数据库处理数据
 *
 *实现了SellService接口，每个方法的用途在SellService接口里有注释
 */

@Service
public class SellServiceImpl implements SellService {

	/**
	 * SellDao接口实例，用于调用SellDao接口里的方法
	 * 
	 * @Autowired 从spring容器里查找SellDao实例，并将容器里的SellDao实例赋给sellDao
	 */
	@Autowired
	private SellDao sellDao;
	
	@Autowired
	Paging paging;
	
	public SellServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public SellServiceImpl(SellDao sellDao) {
		super();
		this.sellDao = sellDao;
	}


	@Override
	public Sell addSell(Sell sell) {
		sellDao.addSell(sell);
		return null;
	}


	/**
	 * 查询销售的分页方法
	 * 此方法用于分页支持，根据传入的behavior参数判断用户进行的上一页、下一页、首页、尾页操作
	 * 第一次访问调用queryAllPhone方法查询数据，再把所查询到的数据传入到储存分页数据的ArrayList里
	 */
	@Override
	public ArrayList querySell(String sell, String brand, String date, String behavior) {
		if(behavior==null || behavior.equals("查询")) {
			ArrayList list = queryAllSell(sell,brand,date);
			paging.setList(list);
			return paging.first();
		}else if(behavior.equals("first")) {
			return paging.first();
		}else if(behavior.equals("up")) {
			return paging.up();
		}else if(behavior.equals("next")) {
			return paging.next();
		}else {
			return paging.last();
		}
	}



	@Override
	public ArrayList queryAllRetailer() {
		return sellDao.queryAllRetailer();
	}



	@Override
	public ArrayList queryAllBrand() {
		return sellDao.queryAllBrand();
	}


	@Override
	public ArrayList queryAllSell(String sell, String brand, String date) {
		Map map = new HashMap();
		map.put("sell", sell);
		map.put("brand", brand);
		map.put("date", date);
		ArrayList temp = sellDao.queryAllSell(map);
		return temp;
	}


	@Override
	public ArrayList queryPhoneType(String brand, String date) {
		return sellDao.queryPhoneType(brand, date);
	}


	@Override
	public Map queryTypeNumber(ArrayList list, String date) {
		Map map = new HashMap();
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i), sellDao.queryTypeNumber(list.get(i), date));
		}
		return map;
	}


	/**
	 * 销售商报表分页方法
	 * 此方法用于分页支持，根据传入的behavior参数判断用户进行的上一页、下一页、首页、尾页操作
	 * 第一次访问调用queryAllPhone方法查询数据，再把所查询到的数据传入到储存分页数据的ArrayList里
	 */
	@Override
	public ArrayList querySalesVolume(String year, String behavior) {
		if(behavior==null || behavior.equals("查询")) {
			ArrayList list = sellDao.querySalesVolume(year);
			paging.setList(list);
			return paging.first();
		}else if(behavior.equals("first")) {
			return paging.first();
		}else if(behavior.equals("up")) {
			return paging.up();
		}else if(behavior.equals("next")) {
			return paging.next();
		}else {
			return paging.last();
		}
	}


	/**
	 * 区域报表的分页方法
	 * 此方法用于分页支持，根据传入的behavior参数判断用户进行的上一页、下一页、首页、尾页操作
	 * 第一次访问调用queryAllPhone方法查询数据，再把所查询到的数据传入到储存分页数据的ArrayList里
	 */
	@Override
	public ArrayList queryAllArea(String year, String behavior) {
		if(behavior==null || behavior.equals("查询")) {
			ArrayList list = sellDao.queryAllArea(year);
			paging.setList(list);
			return paging.first();
		}else if(behavior.equals("first")) {
			return paging.first();
		}else if(behavior.equals("up")) {
			return paging.up();
		}else if(behavior.equals("next")) {
			return paging.next();
		}else {
			return paging.last();
		}
	}


	@Override
	public ArrayList queryAllNum(ArrayList list) {
		ArrayList arrayList = new ArrayList();
		for(int i=0; i<list.size(); i++) {
			Map map = new HashMap();
			map.put(list.get(i), sellDao.queryAllNum((String)list.get(i)));
			arrayList.add(map);
		}
		return arrayList;
	}


}
