package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.utils.Paging;
import com.easytop.psm.web.superclass.SuperClassServlet;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *查询销售商servlet处理类
 */

@WebServlet("/QueryRetailerServlet")
public class QueryRetailerServlet extends SuperClassServlet {

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		/**
		 * 获取用户输入的所有数据
		 */
		String keyword = req.getParameter("keyword");
		String area = req.getParameter("area");
		String behavior = req.getParameter("behavior");
		
		
		//查询页面显示所需的数据
		ArrayList retailerList = retailerService.queryRetailer(keyword, area, behavior);
		ArrayList areaList = retailerService.queryAllArea();
		
		
		//将数据设置到HttpServletRequest对象中，在jsp页面可以用requestScope获取到
		req.setAttribute("retailerList", retailerList);
		req.setAttribute("areaList", areaList);
		req.setAttribute("keyword", keyword);
		req.setAttribute("area", area);
		req.setAttribute("retailerNumber", paging.getAmount());
		req.setAttribute("pagination", paging.getPagination());
		req.setAttribute("num", paging.getNum());
		
		
		//页面转发的地址
		req.getRequestDispatcher("queryRetailer").forward(req, resp);
	}
	
	
}
