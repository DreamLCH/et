package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.model.Phone;
import com.easytop.psm.web.superclass.SuperClassServlet;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *添加手机servlet类
 *
 */

@WebServlet("/AddPhoneServlet")
public class AddPhoneServlet extends SuperClassServlet{

	
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
		String type = req.getParameter("type");
		String brand = req.getParameter("brand");
		String price = req.getParameter("price");
		String colour = req.getParameter("colour");
		String size = req.getParameter("size");
		String date = req.getParameter("date");
		String describe = req.getParameter("describe");
		
		
		/**
		 * 验证输入的价格是否为数字
		 */
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		if(!(pattern.matcher(price).matches())) {
			resp.setCharacterEncoding("GBK");
			resp.getWriter().print("<script language='javascript'>alert('你输入的销售价格不是数字，请重新输入。'); setTimeout('window.history.go(-1)',10);</script>");
			return;
		}
		
		
		
		double prices = Double.parseDouble(price);
		Phone phone = new Phone(0,type,brand,prices,colour,size,date,describe);
		
		
		//调用添加方法
		Phone temp = phoneService.add(phone);
		
		resp.setCharacterEncoding("GBK");
		if(temp==null) {
			//添加成功
			resp.getWriter().print("<script language='javascript'>alert('添加成功。'); setTimeout('window.history.go(-1)',10);</script>");
		}else {
			//添加失败
			resp.getWriter().print("<script language='javascript'>alert('添加失败，型号已存在。'); setTimeout('window.history.go(-1)',10);</script>");
		}
		
	
	}
	
	
}
