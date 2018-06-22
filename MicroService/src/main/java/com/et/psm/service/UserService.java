package com.et.psm.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserService {
	public Map queryUserByName(String name, String password);

	public Map addUser(Map map);

	public Map updateUser(String userName, Map map);

	public Map deleteUser(@Param("name") String name);
}
