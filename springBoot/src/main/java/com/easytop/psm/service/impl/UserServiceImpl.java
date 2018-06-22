package com.easytop.psm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.easytop.psm.dao.UserDao;
import com.easytop.psm.model.User;
import com.easytop.psm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private StringRedisTemplate template;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;


	@Override
	public List<User> queryAllUser(Integer page, Integer limit, String userName, String gender) {
		// TODO Auto-generated method stub
		int startIndex = (page - 1) * limit;
		return userDao.queryAllUser(startIndex, limit, userName, gender);
	}

	@Override
	public int queryAllUserCount(String userName, String gender) {
		// TODO Auto-generated method stub
		return userDao.queryAllUserCount(userName, gender);
	}

	@Override
	public User qeruyUser(int id) {
		String userId = "student" + id;

		if (redisTemplate.hasKey(userId)) {
			return redisTemplate.opsForValue().get(userId);
		} else {
			User user = userDao.qeruyUser(id);
			redisTemplate.opsForValue().set(userId, user);
			return user;
		}
	}

}
