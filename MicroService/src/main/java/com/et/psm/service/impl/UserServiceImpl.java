package com.et.psm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.psm.dao.UserDao;
import com.et.psm.model.User;
import com.et.psm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Override
	public Map queryUserByName(String name, String password) {
		User user = userdao.queryUserByName(name);
		Map map = new HashMap();

		if (user == null) {
			map.put("statuscode", 0);
			map.put("message", "你输入的用户名不存在。");
		} else if (user.getPassword().equals(password)) {
			map.put("statuscode", 1);
			map.put("message", "账号密码正确。");
		} else {
			map.put("statuscode", -1);
			map.put("message", "你输入的密码错误。");
		}
		return map;
	}

	@Override
	public Map addUser(Map map) {
		Map returnMap = new HashMap();
		try {
			userdao.addUser(map);
			returnMap.put("statuscode", 0);
			returnMap.put("message", "添加成功。");
		} catch (Exception e) {
			returnMap.put("statuscode", 1);
			returnMap.put("message", "添加失败。");
		} finally {
			return returnMap;
		}
	}

	@Override
	public Map updateUser(String userName, Map map) {
		Map returnMap = new HashMap();

		try {
			userdao.updateUser(userName, map);
			returnMap.put("statuscode", 0);
			returnMap.put("message", "添加成功。");
		} catch (Exception e) {
			returnMap.put("statuscode", 1);
			returnMap.put("message", "添加失败。");
		} finally {
			return returnMap;
		}
	}

	@Override
	public Map deleteUser(String name) {
		Map returnMap = new HashMap();

		try {
			userdao.deleteUser(name);
			returnMap.put("statuscode", 0);
			returnMap.put("message", "添加成功。");
		} catch (Exception e) {
			returnMap.put("statuscode", 1);
			returnMap.put("message", "添加失败。");
		} finally {
			return returnMap;
		}
	}

}
