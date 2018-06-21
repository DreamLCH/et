package com.et.java.Servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.et.java.users.User;
import com.et.java.users.UserMethod;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userid");
		String password = request.getParameter("pwd");
		
		response.setCharacterEncoding("utf-8");
		
		User user = UserMethod.whetherTheUserExists(username, password);
		
		if(user!=null) {
			response.getWriter().println("账户密码正确，登录成功。");
		}else {
			response.getWriter().println("账户密码错误，登录失败。");
		}
		
	}

}
