package com.et.java.Servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		try {
			resp.sendRedirect(req.getContextPath()+"/welcomeServlet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
