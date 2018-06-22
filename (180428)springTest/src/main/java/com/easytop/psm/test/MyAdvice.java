package com.easytop.psm.test;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Controller;

@Controller
public class MyAdvice {
	
	private final static Logger log = Logger.getLogger(MyAdvice.class);
	
	public void beforelog(JoinPoint jp) {
		log.debug("调用："+jp.getTarget().getClass()+"."+jp.getSignature().getName()+"("+Arrays.toString(jp.getArgs())+")");
	}
	
	
	public void afterlog() {
		System.out.println("这是后置通知。");
	}
}
