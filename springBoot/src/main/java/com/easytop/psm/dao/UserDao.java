package com.easytop.psm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.easytop.psm.model.User;

@Mapper
public interface UserDao {

	public class SqlProvider {
		public String getQueryAllUserSql(Map map) {

			Object userName = map.get("userName");
			Object gender = map.get("gender");
			Object startIndex = map.get("startIndex");
			Object limit = map.get("limit");

			SQL sql = new SQL();
			sql = sql.SELECT("sid id,sname name,sage age,ssex sex").FROM("student");

			if (userName != null && !"".equals(userName)) {
				sql.WHERE("Sname like '%" + userName + "%'");
			}

			if (gender != null && !"".equals(gender)) {
				sql.AND();
				sql.WHERE("Ssex = '" + gender + "'");
			}

			String sqlStr = sql.toString() + " limit " + startIndex + "," + limit;

			return sqlStr;

		}

		public String getQueryAllUserCountSql(Map map) {

			Object userName = map.get("userName");
			Object gender = map.get("gender");

			SQL sql = new SQL();
			sql = sql.SELECT("count(*)").FROM("student");

			if (userName != null && !"".equals(userName)) {
				sql.WHERE("Sname like '%" + userName + "%'");
			}

			if (gender != null && !"".equals(gender)) {
				sql.AND();
				sql.WHERE("Ssex = '" + gender + "'");
			}

			return sql.toString();

		}
	}

	// 调用getQueryAllUserSql方法的sql语句
	@SelectProvider(method = "getQueryAllUserSql", type = SqlProvider.class)
	public List<User> queryAllUser(@Param("startIndex") Integer startIndex, @Param("limit") Integer limit,
			@Param("userName") String userName, @Param("gender") String gender);


	@SelectProvider(method = "getQueryAllUserCountSql", type = SqlProvider.class)
	public int queryAllUserCount(@Param("userName") String userName, @Param("gender") String gender);


	@Select("select sid id,sname name,sage age,ssex sex from student where sid=#{id}")
	public User qeruyUser(@Param("id") int id);
}
