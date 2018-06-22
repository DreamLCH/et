package com.easytop.psm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.model.User;
import com.easytop.psm.web.superclass.SuperClassServlet;



/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *处理登录servlet处理类
 */
@WebServlet("/loginServlet")
public class LoginServlet extends SuperClassServlet {

	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**
		 * 获取用户输入的所有数据
		 */
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		
		//调用方法，查询用户输入的账号密码数据库是否存在
		User user = new User(name,password);
		User temp = userService.getUserByName(user);
		
		
		if(temp==null) {
			//登录失败，账号密码错误
			resp.setCharacterEncoding("GBK");
			resp.getWriter().print("<script language='javascript'>alert('你输入的账号密码错误，请重新输入。'); setTimeout('window.history.go(-1)',10);</script>");
		}else {
			//登录成功，页面转发到主页显示
			resp.sendRedirect(req.getContextPath()+"/QueryPhoneServlet");
		}
	}
	
}
