package com.antbean.spring_boot_demo_mvc.web.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice声明一个控制器建言，@ControllerAdvice组合了@Component，会自动注册为Spring的Bean
@ControllerAdvice
public class ExceptionHandlerAdvice {

	// @ExceptionHandler定义全局异常处理，通过value属性可过滤拦截条件
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errMsg", exception.getMessage());
		return modelAndView;
	}

	// @ModelAttribute本来的作用是绑定键值对到Model里，此处是让全局的@RequestMapping都能获取到此处设置的键值对
	@ModelAttribute
	public void addAttributes(Model model) {
//		model.addAttribute("msg", "额外信息");
	}

	// 用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
//		webDataBinder.setDisallowedFields("userId"); // 此处是忽略请求参数userId
	}

}
