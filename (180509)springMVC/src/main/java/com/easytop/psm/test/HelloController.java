package com.easytop.psm.test;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HelloController{
	
	
	@RequestMapping(value="/user/{name}",method=RequestMethod.GET)
	public String index(@PathVariable String name,HttpServletResponse response) throws IOException {
		/*User user = userDao.getUserByName(id);*/
		response.getWriter().println("hello "+name);
		return null;
		
	}
	
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String index2(@RequestParam(value="name",required=false) String name,HttpServletResponse response) throws IOException {
		/*User user = userDao.getUserByName(id);*/
		response.getWriter().println("hello "+name);
		return null;
	}
}
