package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.web.superclass.SuperClassServlet;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *销售录入时查询处理类
 */

@WebServlet("/SellQueryTranspondServlet")
public class SellQueryTranspondServlet extends SuperClassServlet {

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//查询页面显示所需的数据
		ArrayList retailerName = retailerService.queryAllRetailer(null, null);
		ArrayList phoneBrand = phoneService.queryAllBrand();
		Map phoneMap = phoneService.queryAllData(phoneBrand);
		
		
		//将数据设置到HttpServletRequest对象中，在jsp页面可以用requestScope获取到
		req.setAttribute("retailerName", retailerName);
		req.setAttribute("phoneMap", phoneMap);
		
		
		//页面转发的地址
		req.getRequestDispatcher("sellAdd").forward(req, resp);
		
	}
	
	
	
	
}
