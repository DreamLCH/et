package com.easytop.psm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytop.psm.dao.PhoneDao;
import com.easytop.psm.model.Phone;
import com.easytop.psm.service.PhoneService;
import com.easytop.psm.utils.Paging;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *          手机业务逻辑处理类，用于调用dao层接口里的方法来连接数据库处理数据
 *
 *          实现了PhoneService接口，每个方法的用途在PhoneService接口里有注释
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

		if (temp != null) {
			return temp;
		}

		phoneDao.add(phone);
		return null;
	}

	public void deletePhone(int id) {
		phoneDao.deletePhone(id);
	}
	
	
	@Override
	public Phone getPhoneByType(String type) {
		Phone temp = phoneDao.getPhoneByType(type);
		return temp;
	}

	
	
	public ArrayList queryAllPhone(String search, int offset, int limit) {

		Map map = new HashMap();
		map.put("search", search);
		map.put("offset", offset);
		map.put("limit", limit);
		ArrayList temp = phoneDao.queryAllPhone(map);
		return temp;
	}


	public int queryAllRecord(String search) {
		return phoneDao.queryAllRecord(search);
	}

	
	
	@Override
	public ArrayList queryAllBrand() {
		return phoneDao.queryAllBrand();
	}

	

	@Override
	public Map queryAllData(ArrayList list) {

		Map map = new HashMap();

		// 遍历list里面所有的手机品牌，根据手机品牌调用queryAllData方法查询对应的手机数据
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), phoneDao.queryAllData(list.get(i)));
		}

		return map;
	}


}

