package com.et.java.Servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req,resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("GBK");
		resp.getWriter().println("你好.");
	}
}
