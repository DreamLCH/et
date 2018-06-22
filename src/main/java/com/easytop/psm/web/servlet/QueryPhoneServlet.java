package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.easytop.psm.utils.Paging;
import com.easytop.psm.web.superclass.SuperClassServlet;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *查询手机servlet处理类
 */

@WebServlet("/QueryPhoneServlet")
@Controller
public class QueryPhoneServlet extends SuperClassServlet {

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
		String behavior = req.getParameter("behavior");
		String keyword = req.getParameter("keyword");
		String brand = req.getParameter("brand");
		String price1 = req.getParameter("price1");
		String price2 = req.getParameter("price2");
		
		
		
		//查询页面显示所需的数据
		ArrayList arrayList = phoneService.queryAllBrand();
		ArrayList phoneList = phoneService.queryPhone(keyword, brand, price1, price2,behavior);
		
		
		
		//将数据设置到HttpServletRequest对象中，在jsp页面可以用requestScope获取到
		req.setAttribute("arrayList", arrayList);
		req.setAttribute("phoneList", phoneList);
		req.setAttribute("phoneNumber", paging.getAmount());
		req.setAttribute("pagination", paging.getPagination());
		req.setAttribute("num", paging.getNum());
		req.setAttribute("brand", brand);
		req.setAttribute("price1", price1);
		req.setAttribute("price2", price2);
		
		
		//页面转发的地址
		req.getRequestDispatcher("queryPhone").forward(req, resp);
	}
	
	
	
	
}
