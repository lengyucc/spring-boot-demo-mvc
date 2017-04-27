package com.antbean.spring_boot_demo_mvc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antbean.spring_boot_demo_mvc.domain.User;

@RestController // @RestController组合了@Controller和@ResponseBody
@RequestMapping("/rest")
public class DemoRestController {

	@RequestMapping(value = "getjson", produces = "application/json;charset=UTF-8")
	public Object getjson(User user) {
		user.setUserId(System.currentTimeMillis());
		return user;
	}

	@RequestMapping(value = "getxml", produces = "application/xml;charset=UTF-8")
	public Object getxml(User user) {
		user.setUserId(System.currentTimeMillis());
		return user;
	}

}
