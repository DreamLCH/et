package com.easytop.psm.web.superclass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;

import com.easytop.psm.service.PhoneService;
import com.easytop.psm.service.RetailerService;
import com.easytop.psm.service.SellService;
import com.easytop.psm.service.UserService;
import com.easytop.psm.utils.Paging;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *servlet类的父类，继承这个类就可以拿到本类里面的所有变量
 *sellService变量：用于调用SellService接口里面的方法
 *phoneService变量：用于调用PhoneService接口里面的方法
 *retailerService变量：用于调用RetailerService接口里面的方法
 *paging变量：用于调用paging接口里面的方法
 */
public class SuperClassServlet extends HttpServlet{

	protected SellService sellService;
	protected PhoneService phoneService;
	protected RetailerService retailerService;
	protected UserService userService;
	protected Paging paging;
	private  ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		
		/**
		 * 通过上下文对象获得ApplicationContext对象，然后getBean从spring容器里得到SellService、PhoneService、RetailerService接口的实例对象
		 */
		
		 context = (ApplicationContext)getServletContext().getAttribute(ApplicationContext.class.getName());
		 sellService = context.getBean(SellService.class);
		 phoneService = context.getBean(PhoneService.class);
		 retailerService = context.getBean(RetailerService.class);
		 userService = context.getBean(UserService.class);
		 paging = context.getBean(Paging.class);
	}

}
