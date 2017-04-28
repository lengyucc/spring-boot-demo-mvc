package com.antbean.spring_boot_demo_mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antbean.spring_boot_demo_mvc.service.DemoService;

@RestController
public class MyRestController {
	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
	public Object testPage() {
		return demoService.saySomething();
	}
}
