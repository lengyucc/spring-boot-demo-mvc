package com.antbean.spring_boot_demo_mvc.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {
	private long startTime;
	private long endTime;

	// preHandle在请求发生前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTime = System.currentTimeMillis();
		return true;
	}

	// postHandle在请求完成后执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		endTime = System.currentTimeMillis();
		System.out.println(request.getRequestURL() + "\t耗时:" + (endTime - startTime));
	}

}
