package com.easytop.psm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class ApplicationMain {

	@Value("${a}")
	private String port;


	@RequestMapping("/port")
	public String hello() {
		return port;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
}
