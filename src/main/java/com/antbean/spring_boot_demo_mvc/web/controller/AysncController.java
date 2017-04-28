package com.antbean.spring_boot_demo_mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.antbean.spring_boot_demo_mvc.service.PushService;

@Controller
public class AysncController {
	@Autowired
	private PushService pushService;

	/*
	 * 异步任务的实现是通过控制器从另外一个线程返回一个DeferredResult
	 */
	@RequestMapping("/defer")
	public @ResponseBody DeferredResult<String> deferredCall() {
		System.out.println(System.currentTimeMillis() + " --->> before controller");
		DeferredResult<String> result = pushService.getAsyncUpdate();
		System.out.println(System.currentTimeMillis() + " --->> alter controller \t" + result.getResult());
		return result; // 在DeferredResult.getResult()==null的时候结果就已经被返回了(设想：可能在某个HttpMessageConvert中,
		// 对DeferredResult中的result是否为null进行判断，如果为null,线程等待,否则返回result)
	}
}
