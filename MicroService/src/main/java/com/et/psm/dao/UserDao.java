package com.et.psm.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.et.psm.model.User;

@Mapper
public interface UserDao {

	@Select("select id name,pwd password from userlogin where id = #{name}")
	public User queryUserByName(@Param("name") String name);

	@Insert("insert into userlogin values(#{userName},#{password})")
	public void addUser(Map map);

	@Update("update userlogin set pwd=#{m.password} where id=#{userName}")
	public void updateUser(@Param("userName") String userName, @Param("m") Map map);

	@Delete("delete from userlogin where id=#{name}")
	public void deleteUser(@Param("name") String name);
}
