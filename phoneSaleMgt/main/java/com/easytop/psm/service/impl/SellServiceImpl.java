package com.easytop.psm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


	public void deleteSell(int id) {
		sellDao.deleteSell(id);
	}



	public List querySellData(String search, int offset, int limit) {

		Map map = new HashMap();
		map.put("search", search);
		map.put("offset", offset);
		map.put("limit", limit);

		ArrayList temp = sellDao.querySellData(map);
		return temp;

	}


	public int queryAllRecord(String search) {
		return sellDao.queryAllRecord(search);
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
	public ArrayList queryAllSell(String brand, String date, int offset, int limit) {
		Map map = new HashMap();
		map.put("brand", brand);
		map.put("date", date);
		map.put("offset", offset);
		map.put("limit", limit);
		ArrayList temp = sellDao.queryAllSell(map);
		return temp;
	}

	public int queryAllSellRecord(String brand, String date) {
		Map map = new HashMap();
		map.put("brand", brand);
		map.put("date", date);
		int record = sellDao.queryAllSellRecord(map);
		return record;
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


	@Override
	public ArrayList querySalesVolume(String year, int offset, int limit) {
		Map map = new HashMap();
		map.put("year", year);
		map.put("offset", offset);
		map.put("limit", limit);
		ArrayList temp = sellDao.querySalesVolume(map);
		return temp;
	}


	public int queryAllRetailerRecord(String year) {
		return sellDao.queryAllRetailerRecord(year);
	}



	@Override
	public ArrayList queryAllArea(String year, int offset, int limit) {
		Map map = new HashMap();
		map.put("year", year);
		map.put("offset", offset);
		map.put("limit", limit);
		ArrayList temp = sellDao.queryAllArea(map);
		return temp;
	}


	public int queryAllAreaRecord(String year) {
		return sellDao.queryAllAreaRecord(year);
	}


	@Override
	public ArrayList queryAllNum(ArrayList list, String year) {
		ArrayList arrayList = new ArrayList();
		for(int i=0; i<list.size(); i++) {
			Map map = new HashMap();
			map.put(list.get(i), sellDao.queryAllNum((String) list.get(i), year));
			arrayList.add(map);
		}
		return arrayList;
	}



}
