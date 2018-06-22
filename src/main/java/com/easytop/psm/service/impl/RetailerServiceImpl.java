package com.easytop.psm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytop.psm.dao.RetailerDao;
import com.easytop.psm.model.Retailer;
import com.easytop.psm.model.Sell;
import com.easytop.psm.service.RetailerService;
import com.easytop.psm.utils.Paging;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *销售商业务逻辑处理类，用于调用dao层接口里的方法来连接数据库处理数据
 *
 *实现了RetailerService接口，每个方法的用途在RetailerService接口里有注释
 */

@Service
public class RetailerServiceImpl implements RetailerService {
	
	
	/**
	 * RetailerDao接口实例，用于调用RetailerDao里的方法
	 * 
	 * @Autowired 从spring容器里查找RetailerDao实例，并将容器里的RetailerDao实例赋给retailerDao
	 */
	@Autowired
	private RetailerDao retailerDao;
	
	@Autowired
	Paging paging;
	
	
	public RetailerServiceImpl() {
		super();
	}
	

	public RetailerServiceImpl(RetailerDao retailerDao) {
		super();
		this.retailerDao = retailerDao;
	}


	@Override
	public Retailer addRetailer(Retailer retailer) {
		
		Retailer temp = retailerDao.getRetailerByName(retailer.getName());

		if(temp!=null) {
			return temp;
		}
		
		retailerDao.addRetailer(retailer);
		return temp;
	}

	@Override
	public Retailer getRetailerByName(String name) {
		Retailer temp =  retailerDao.getRetailerByName(name);
		return temp;
	}
	
	
	
	@Override
	public ArrayList queryAllRetailer(String keyword, String area) {
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("area", area);
		ArrayList temp = retailerDao.queryAllRetailer(map);
		return temp;
	}
	
	
	
	/**
	 * 此方法用于分页支持，根据传入的behavior参数判断用户进行的上一页、下一页、首页、尾页操作
	 * 第一次访问调用queryAllPhone方法查询数据，再把所查询到的数据传入到储存分页数据的ArrayList里
	 */
	@Override
	public ArrayList queryRetailer(String keyword, String area, String behavior) {
		
		if(behavior==null || behavior.equals("查询")) {
			ArrayList list = queryAllRetailer(keyword,area);
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
	public ArrayList queryAllArea() {
		return retailerDao.queryAllArea();
	}


	
	public Map queryArea(ArrayList<Sell> list) {
		Map map = new HashMap();
		
		for(int i=0; i<list.size(); i++) {
			map.put(retailerDao.queryArea(list.get(i).getName())+i, list.get(i));
		}
		
		return map;
	}
	
	
}
