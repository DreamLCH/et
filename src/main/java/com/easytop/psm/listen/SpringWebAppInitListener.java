package com.easytop.psm.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @author 梁琛华
 * @version 1.0
 * 
 * 用拦截器拦截到项目运行时，读取spring.xml里的文件。
 *
 */
public class SpringWebAppInitListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		/**
		 * 读取spring.xml文件，获得ApplicationContext对象，把context存入上下文对象中
		 */
		ApplicationContext context= new ClassPathXmlApplicationContext("classpath:spring.xml");
		
		sce.getServletContext().setAttribute(ApplicationContext.class.getName(), context);
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	

}
