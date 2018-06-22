package com.easytop.psm.web.controller;

import java.io.OutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easytop.psm.model.User;
import com.easytop.psm.service.UserService;
import com.easytop.psm.utils.HintTool;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *          用户控制层
 */

@Controller
public class UserLoginController {

	// UserService接口，用于调用DAO层里的方法
	@Autowired
	private UserService userService;

	// 消息提示工具类
	@Autowired
	private HintTool hintTool;

	/**
	 * 第一次访问JSP页面的时候页面的user对象没有传值，该方法添加了@ModelAttribute注解，访问该类任何方法都会先调用此方法
	 * 然后把对象传给页面，防止JSP页面报错
	 * 
	 * @return
	 */
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	/**
	 * 转发到login.JSP页面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String tologin() {
		return "login";
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            user对象
	 * @param error
	 *            校验后结果对象，可以判断校验是否有错误，错误信息也储存在该对象中
	 * @param out
	 *            字节输出流
	 * @return
	 */
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String queryUserByName(@Valid User user, BindingResult error, OutputStream out) {

		if (error.hasErrors()) {
			// 校验到用户有错误输入，重新返回到登录页面
			return "login";
		}

		// 调用查询方法，查询输入的用户账号密码是否正确
		User temp = userService.getUserByName(user);

		if (temp == null) {
			// 登录失败，账号密码错误
			hintTool.returnHint("登录失败，账号密码错误。", out);
			return null;
		}

		return "redirect:/query/phone";
	}
	
	
	

}
