package com.et.java.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 获取当前会话对象
		HttpSession session = req.getSession();
		
		// 获取请求参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 将登陆过的信息保存到当前会话对象中
		session.setAttribute("login-info", username+","+password);
		
		req.getRequestDispatcher("/register.html").forward(req, resp);
		
	}
}
