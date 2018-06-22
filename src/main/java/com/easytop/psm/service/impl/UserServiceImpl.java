package com.easytop.psm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytop.psm.dao.UserDao;
import com.easytop.psm.model.User;
import com.easytop.psm.service.UserService;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *用户业务逻辑处理类，用于调用dao层接口里的方法来连接数据库处理数据
 *
 *实现了UserService接口，每个方法的用途在UserService接口里有注释
 */
@Service
public class UserServiceImpl implements UserService {
	
	
	/**
	 * UserDao接口实例，用于调用UserDao接口里的方法
	 * 
	 * @Autowired 从spring容器里查找UserDao实例，并将容器里的UserDao实例赋给userDao
	 */
	@Autowired
	private UserDao userDao;
	
	
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public User getUserByName(User user) {
		return userDao.getUserByName(user);
	}

}
