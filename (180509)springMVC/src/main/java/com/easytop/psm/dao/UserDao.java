package com.easytop.psm.dao;

import org.apache.ibatis.annotations.Select;

import com.easytop.psm.test.User;

public interface UserDao {
	
	@Select("select * from user where id = #{0}")
	User getUserByName(int id);
}
