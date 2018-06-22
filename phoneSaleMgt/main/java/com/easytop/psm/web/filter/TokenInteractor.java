package com.easytop.psm.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *          拦截器，判断校验表单隐藏域跟session的uuid是否相同 ，防止重复提交
 */
public class TokenInteractor implements HandlerInterceptor {


	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String myToken = request.getParameter("myToken");
		Object myToken1 = request.getSession().getAttribute("myToken");
		// 需要验证重复提交
		if (myToken != null) {
			// 重复提交
			if (myToken1 == null) {
				// 重复提交重定向到/repeatSubmit映射的方法处理
				response.sendRedirect("/repeatSubmit");
				return false;
			} else {
				if (myToken.equals(myToken1)) {
					// myToken和myToken1相同，可以提交，然后清除session
					request.getSession().removeAttribute("myToken");
					return true;
				} else {
					response.sendRedirect("/repeatSubmit");
					return false;
				}
			}
		} else {
			return true;
		}
	}

}
