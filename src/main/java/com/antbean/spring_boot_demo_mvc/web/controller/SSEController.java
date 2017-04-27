package com.antbean.spring_boot_demo_mvc.web.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// 演示失败
@Controller
public class SSEController {

	// 输出媒体使用text/event-stream，这是服务端sse的支持，本例演示每5秒钟向浏览器推送随机消息
	@RequestMapping(value = "/push", produces = "text/event-stream")
	public @ResponseBody String push() {
		Random random = new Random();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "hahahha:" + random.nextLong() + "\n\n";
	}
}
