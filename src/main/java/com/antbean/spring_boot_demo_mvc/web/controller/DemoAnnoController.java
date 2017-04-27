package com.antbean.spring_boot_demo_mvc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antbean.spring_boot_demo_mvc.domain.User;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

	// @RequestMapping如果不指定value值，则默认与类级别上的@RequestMapping路径相同
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access";
	}

	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access,str: " + str;
	}

	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access,id: " + id;
	}

	@RequestMapping(value = "/user", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passObj(User user, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access,user: " + user;
	}

	@RequestMapping(value = { "/path1", "/path2" }, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access";
	}

}
