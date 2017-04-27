package com.antbean.spring_boot_demo_mvc.web.converter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.antbean.spring_boot_demo_mvc.domain.User;

// 继承AbstractHttpMessageConverter类来实现自定义的HttpMessageConverter
public class MyMessageConverter extends AbstractHttpMessageConverter<User> {

	public MyMessageConverter() {
		// 新建一个自定义的媒体类型application/x-wisely
		super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// 表明此HttpMessageConverter只处理User类
		return User.class.isAssignableFrom(clazz);
	}

	// 重写readInternal，处理请求数据
	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] tempAttr = temp.split("#");
		return new User(new Long(tempAttr[0]), tempAttr[1], tempAttr[2]);
	}

	// 重写writeInternal，处理如何输出数据到response
	@Override
	protected void writeInternal(User t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = t.toString() + ":hahahha";
		outputMessage.getBody().write(out.getBytes());
	}

}
