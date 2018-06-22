package com.easytop.psm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytop.psm.dao.PhoneDao;
import com.easytop.psm.model.Phone;
import com.easytop.psm.model.Sell;
import com.easytop.psm.service.PhoneService;
import com.easytop.psm.utils.Paging;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *手机业务逻辑处理类，用于调用dao层接口里的方法来连接数据库处理数据
 *
 *实现了PhoneService接口，每个方法的用途在PhoneService接口里有注释
 */

@Service
public class PhoneServiceImpl implements PhoneService {
	
	/**
	 * PhoneDao接口的实例，用于调用PhoneDao接口里的方法
	 * 
	 * @Autowired 从spring容器里查找PhoneDao实例，并将容器里的PhoneDao实例赋给phoneDao
	 */
	@Autowired
	PhoneDao phoneDao;
	
	@Autowired
	Paging paging;
	
	
	@Override
	public Phone add(Phone phone) {
		
		Phone temp = phoneDao.getPhoneByType(phone.getType());
		
		if(temp!=null) {
			return temp;
		}
			
		phoneDao.add(phone);
		return null;
	}
	

	@Override
	public Phone getPhoneByType(String type) {
		Phone temp = phoneDao.getPhoneByType(type);
		return temp;
	}
	
	
	
	public ArrayList queryAllPhone(String keyword, String brand, String price1, String price2) {
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("brand", brand);
		map.put("price1", price1);
		map.put("price2", price2);
		ArrayList temp = phoneDao.queryAllPhone(map);
		return temp;
	}
	
	
	/**
	 * 此方法用于分页支持，根据传入的behavior参数判断用户进行的上一页、下一页、首页、尾页操作
	 * 第一次访问调用queryAllPhone方法查询数据，再把所查询到的数据传入到储存分页数据的ArrayList里
	 */
	public ArrayList queryPhone(String keyword, String brand, String price1, String price2, String behavior) {
		
		if(behavior==null || behavior.equals("查询")) {
			ArrayList list = queryAllPhone(keyword,brand,price1,price2);
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
	public ArrayList queryAllBrand() {
		return phoneDao.queryAllBrand();
	}


	@Override
	public Map queryAllData(ArrayList list) {
		
		Map map = new HashMap();
		
		//遍历list里面所有的手机品牌，根据手机品牌调用queryAllData方法查询对应的手机数据
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i), phoneDao.queryAllData(list.get(i)));
		}
		
		return map;
	}


	@Override
	public ArrayList querySize(ArrayList<Sell> list) {
		ArrayList arrayList = new ArrayList();
		
		for(int i=0; i<list.size(); i++) {
			ArrayList temp = new ArrayList();
			temp.add(phoneDao.getPhoneByType(list.get(i).getType()));
			temp.add(list.get(i));
			arrayList.add(temp);
		}
		
		return arrayList;
	}
	
}
