package com.easytop.psm.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.easytop.psm.model.User;


public interface UserService {
	
	/**
	 * 用于查询输入的账号密码是否与数据库里数据匹配
	 * 
	 * @param user	用户对象
	 * @return
	 */
	User getUserByName(User user);
}
