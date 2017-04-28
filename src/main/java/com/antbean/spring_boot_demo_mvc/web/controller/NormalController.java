package com.antbean.spring_boot_demo_mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antbean.spring_boot_demo_mvc.service.DemoService;

@Controller
public class NormalController {
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/normal")
	public String testPage(Model model){
		model.addAttribute("msg", demoService.saySomething());
		return "page";
	}
}
