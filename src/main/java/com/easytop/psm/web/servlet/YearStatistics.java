package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * 按月份统计处理类
 */

@WebServlet("/YearStatistics")
public class YearStatistics extends SuperClassServlet {

	
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
		String year = req.getParameter("year");
		
		
		/**
		 * 判断变量是否为空，如果为空设置默认值
		 */
		if(year==null) {
			year="2018";
		}
		
		
		//查询页面显示所需的数据
		ArrayList list = sellService.queryAllBrand();
		ArrayList sellList = sellService.queryAllNum(list);
		
		
		//将数据设置到HttpServletRequest对象中，在jsp页面可以用requestScope获取到
		req.setAttribute("year", year);
		req.setAttribute("list", list);
		req.setAttribute("sellList", sellList);
		
		
		//页面转发的地址
		req.getRequestDispatcher("yearStatistics").forward(req, resp);
	}
	

}
