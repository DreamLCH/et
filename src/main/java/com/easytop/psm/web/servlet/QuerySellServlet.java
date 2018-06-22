package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.service.RetailerService;
import com.easytop.psm.service.SellService;
import com.easytop.psm.utils.Paging;
import com.easytop.psm.web.superclass.SuperClassServlet;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *查询销售信息servlet处理类
 */

@WebServlet("/QuerySellServlet")
public class QuerySellServlet extends SuperClassServlet {

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
		String retailer = req.getParameter("retailer");
		String brand = req.getParameter("brand");
		String date = req.getParameter("date");
		String behavior = req.getParameter("behavior");
		
		
		//查询页面显示所需的数据
		ArrayList retailerName = sellService.queryAllRetailer();
		ArrayList phoneBrand = sellService.queryAllBrand();
		ArrayList allSell = sellService.querySell(retailer, brand, date, behavior);
		Map areaMap = retailerService.queryArea(allSell);
		
		
		//将数据设置到HttpServletRequest对象中，在jsp页面可以用requestScope获取到
		req.setAttribute("retailerName", retailerName);
		req.setAttribute("phoneBrand", phoneBrand);
		req.setAttribute("areaMap", areaMap);
		req.setAttribute("sellNumber", paging.getAmount());
		req.setAttribute("pagination", paging.getPagination());
		req.setAttribute("num", paging.getNum());
		req.setAttribute("retailer", retailer);
		req.setAttribute("brand", brand);
		req.setAttribute("date", date);
		
		
		//页面转发的地址
		req.getRequestDispatcher("querySell").forward(req, resp);
	}
	
	
	

}
