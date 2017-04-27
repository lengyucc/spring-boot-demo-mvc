package com.antbean.spring_boot_demo_mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antbean.spring_boot_demo_mvc.domain.User;

@Controller
public class AdviceController {
	// 测试地址http://localhost:8081/spring-boot-demo-mvc/advice?userId=110&username=zhangss&password=111222
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg, User user) {
		throw new IllegalArgumentException("参数异常:" + msg);
	}
}
