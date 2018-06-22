package com.easytop.psm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytop.psm.model.ResponseEnt;
import com.easytop.psm.model.User;
import com.easytop.psm.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;


	@RequestMapping("/queryAll/user")
	public ResponseEnt queryAllUser(Integer page, Integer limit, String userName, String gender) {
		List user = userService.queryAllUser(page, limit, userName, gender);
		int userCount = userService.queryAllUserCount(userName, gender);

		ResponseEnt re = new ResponseEnt();
		re.setData(user);
		re.setCount(userCount);

		return re;

	}

	@RequestMapping("/query/user")
	public User queryUser(int id) {

		return userService.qeruyUser(id);

	}
}
