package com.antbean.spring_boot_demo_mvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {
	private DeferredResult<String> deferredResult;

	public DeferredResult<String> getAsyncUpdate() { // 产生DeferredResult给controller使用
		System.out.println(System.currentTimeMillis() + " --->> before service");
		deferredResult = new DeferredResult<String>();
		System.out.println(System.currentTimeMillis() + " --->> after service");
		return deferredResult;
	}

	// 定时任务，定时更新DeferredResult
	@Scheduled(fixedDelay = 30000) // 别忘在config中配置@EnableScheduling
	public void refresh() { // 定时更新DeferredResult
		if (null != deferredResult) {
			System.out.println(System.currentTimeMillis() + " --->> before Scheduled");
			deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
			System.out.println(System.currentTimeMillis() + " --->> after Scheduled");
		}
	}
}
