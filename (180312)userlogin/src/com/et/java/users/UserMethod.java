package com.et.java.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.et.java.cu.ConnectionUtils;

public class UserMethod {
	
	
	public static Connection c = ConnectionUtils.getConnection();
	
	
	public static User whetherTheUserExists(String id,String password){
		
		if(id.equals("") || password.equals("")) {
			return null;
		}
		String sql = "select * from userlogin where id="+id+" and pwd="+password;
		Statement s = null;
		ResultSet rs = null;
		User user = null;
		try {
			s = c.createStatement();
			rs = s.executeQuery(sql);
			
			if(rs.next()){
				if(id.equals(rs.getString(1)+"")){
					user = new User(rs.getString(1),rs.getString(2));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				s.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
