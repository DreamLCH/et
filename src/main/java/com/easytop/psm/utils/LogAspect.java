package com.easytop.psm.utils;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *日志通知切面类
 */
public class LogAspect {
	
	private final static Logger log = Logger.getLogger(LogAspect.class);
	
	/**
	 * 前置通知，在com.easytop.psm.service.impl的每个类里的每个方法的执行前添加一个前置通知
	 * @param jp
	 */
	public void beforeLogger(JoinPoint jp){
		log.debug("调用："+jp.getTarget().getClass()+"."+jp.getSignature().getName()+"("+Arrays.toString(jp.getArgs())+")");
	}
	
	
	
	/**
	 * 后置通知，在com.easytop.psm.service.impl的每个类里的每个方法的执行完后添加一个后置通知
	 * @param jp
	 */
	public void afterlogLogger(JoinPoint jp){
		log.debug("调用："+jp.getTarget().getClass()+"."+jp.getSignature().getName()+"，完毕。");
	}
	
	
}
