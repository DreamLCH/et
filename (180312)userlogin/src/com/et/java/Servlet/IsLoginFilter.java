package com.et.java.Servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class IsLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String loginInfo = (String) session.getAttribute("login-info");
		
		if(loginInfo !=null && !loginInfo.trim().equals("")) {
			chain.doFilter(request, response);
			return;
		}
		
		System.out.println("请先登录。");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
