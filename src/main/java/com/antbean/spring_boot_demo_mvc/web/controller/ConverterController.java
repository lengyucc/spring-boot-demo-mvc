package com.antbean.spring_boot_demo_mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antbean.spring_boot_demo_mvc.domain.User;

@Controller
public class ConverterController {
	// 测试地址http://localhost:8081/spring-boot-demo-mvc/converter
	@RequestMapping(value = "/convert", produces = { "application/x-wisely" })
	public @ResponseBody Object convert(@RequestBody User user) {	// @RequestBody不可少
		return user;
	}
}
