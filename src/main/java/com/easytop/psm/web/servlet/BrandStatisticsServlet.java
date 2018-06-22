package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.service.PhoneService;
import com.easytop.psm.service.SellService;
import com.easytop.psm.utils.Paging;
import com.easytop.psm.web.superclass.SuperClassServlet;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *品牌统计servlet处理类
 */


@WebServlet("/BrandStatisticsServlet")
public class BrandStatisticsServlet extends SuperClassServlet {

	/**
	 * 
	 */
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
		String brand = req.getParameter("brand");
		String year = req.getParameter("year");
		String behavior = req.getParameter("behavior");
		
		
		
		/**
		 * 判断变量是否为空，如果为空设置默认值
		 */
		if(brand==null || brand.equals("")) {
			brand="华为";
		}
		if(year==null || year.equals("")) {
			year="2018";
		}
		
		
		//查询页面显示所需的数据
		ArrayList phoneBrand = sellService.queryAllBrand();
		ArrayList phoneType = sellService.queryPhoneType(brand, year);
		Map sellMap = sellService.queryTypeNumber(phoneType, year);
		ArrayList sellList = sellService.querySell(null, brand, year, behavior);
		ArrayList list = phoneService.querySize(sellList);
		
		
		
		//将数据设置到HttpServletRequest对象中，在jsp页面可以用requestScope获取到
		req.setAttribute("phoneBrand", phoneBrand);
		req.setAttribute("sellMap", sellMap);
		req.setAttribute("brand", brand);
		req.setAttribute("year", year);
		req.setAttribute("list", list);
		req.setAttribute("sellNumber", paging.getAmount());
		req.setAttribute("pagination", paging.getPagination());
		req.setAttribute("num",paging.getNum());
		
		//页面转发的地址
		req.getRequestDispatcher("brandStatistics").forward(req, resp);
	}
	
}
