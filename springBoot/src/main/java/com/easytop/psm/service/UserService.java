package com.easytop.psm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.easytop.psm.model.User;

@Service
public interface UserService {

	public List<User> queryAllUser(Integer page, Integer limit, String userName, String gender);

	public int queryAllUserCount(String userName, String gender);

	public User qeruyUser(@Param("id") int id);
}
