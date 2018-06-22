package com.easytop.psm.web.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easytop.psm.model.Retailer;
import com.easytop.psm.web.superclass.SuperClassServlet;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *添加销售商servlet处理类
 */
@WebServlet("/AddRetailerServlet")
public class AddRetailerServlet extends SuperClassServlet {

	
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
		String area = req.getParameter("area");
		String principal = req.getParameter("principal");
		String phone = req.getParameter("phone");
		String identity = req.getParameter("identity");
		String address = req.getParameter("address");
		String postcode = req.getParameter("postcode");
		
		
		
		
		/**
		 * 验证用户输入的电话号码是否为正确号码
		 */
		resp.setCharacterEncoding("GBK");
		Pattern pattern = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
		if(!(pattern.matcher(phone).matches())) {
			
			resp.getWriter().print("<script language='javascript'>alert('你输入的电话号码格式有误，请重新输入。'); setTimeout('window.history.go(-1)',10);</script>");
			return;
		}
		
		
		
		/**
		 * 验证用户输入的身份证号码是否为身份证号码
		 */
		Pattern authentication = Pattern.compile("^\\d{15}|^\\d{17}([0-9]|X|x)$");
		if(!(authentication.matcher(identity).matches())) {
			
			resp.getWriter().print("<script language='javascript'>alert('你输入的身份证有误，请重新输入。'); setTimeout('window.history.go(-1)',10);</script>");
			return;
		}
		
		
		
		Retailer retailer = new Retailer(0,name,area,principal,phone,identity,address,postcode);
		
		//调用添加方法
		Retailer temp = retailerService.addRetailer(retailer);
		
		
		
		if(temp==null) {
			//添加成功
			resp.getWriter().print("<script language='javascript'>alert('添加成功。'); setTimeout('window.history.go(-1)',10);</script>");
		}else {
			//添加失败
			resp.getWriter().print("<script language='javascript'>alert('添加失败，你输入的销售商名称已存在。'); setTimeout('window.history.go(-1)',10);</script>");
		}
	}
	
	
	
	
}
