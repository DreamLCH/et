package com.easytop.psm.test;

import org.springframework.stereotype.Component;

@Component
public class UserImpl implements User {

	@Override
	public void login() {
		System.out.println("登录");

	}

	@Override
	public void register() {
		System.out.println("注册");

	}

}
