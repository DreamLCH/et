package com.easytop.psm.dao;

import org.apache.ibatis.annotations.Select;

import com.easytop.psm.model.User;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *user用户登录时从 查询账号密码验证接口
 */
public interface UserDao {
	
	/**
	 * 用于查询输入的账号密码是否与数据库里数据匹配
	 * 
	 * @param user	用户对象
	 * @return
	 */
	@Select("select * from administrator where name = #{name} and password = #{password}")
	User getUserByName(User user);
	
	
}
