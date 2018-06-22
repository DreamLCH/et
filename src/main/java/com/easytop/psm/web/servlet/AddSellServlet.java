package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.model.Sell;
import com.easytop.psm.web.superclass.SuperClassServlet;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *添加销售信息servlet处理类
 */
@WebServlet("/AddSellServlet")
public class AddSellServlet extends SuperClassServlet {

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
		String brand = req.getParameter("brand");
		String type = req.getParameter("type");
		String date = req.getParameter("date");
		String number = req.getParameter("number");
		
		
		/**
		 * 验证是否存在销售商，没有销售商无法录入销售信息，必须要先添加销售商
		 */
		resp.setCharacterEncoding("GBK");
		if("".equals(name) || name==null) {
			resp.getWriter().print("<script language='javascript'>alert('无销售商，请先添加销售商。'); setTimeout('window.history.go(-1)',10);</script>");
			return;
		}
		
		
		
		/**
		 * 验证是否存在手机型号，没有手机型号无法录入销售信息，必须要先添加手机
		 */
		if("".equals(type) || type==null) {
			resp.getWriter().print("<script language='javascript'>alert('无手机型号，请先添加手机。'); setTimeout('window.history.go(-1)',10);</script>");
			return;
		}
		
		
		
		/**
		 * 验证输入的销售量是否为数字
		 */
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		if(!(pattern.matcher(number).matches())) {
			resp.getWriter().print("<script language='javascript'>alert('你输入的销售数量不是数字，请重新输入。'); setTimeout('window.history.go(-1)',10);</script>");
			return;
		}
		
		
		Sell sell = new Sell(name,brand,type,date,Integer.valueOf(number));
		
		//调用添加方法
		sellService.addSell(sell);
		
		resp.getWriter().print("<script language='javascript'>alert('录入成功。'); setTimeout('window.history.go(-1)',10);</script>");
		
	}

}
