package com.antbean.spring_boot_demo_mvc.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public String saySomething() {
		return "hello";
	}
}
