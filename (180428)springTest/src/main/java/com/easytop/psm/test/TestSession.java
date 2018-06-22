package com.easytop.psm.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = "a";
		String value = "temp";
		req.getSession().setAttribute(key, value);
		
		System.out.println(req.getSession().getAttribute(key));
		
		req.getSession().removeAttribute(key);
		
		System.out.println(req.getSession().getAttribute(key));
	}
	
}
