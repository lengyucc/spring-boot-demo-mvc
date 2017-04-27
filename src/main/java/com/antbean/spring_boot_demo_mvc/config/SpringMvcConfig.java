package com.antbean.spring_boot_demo_mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.antbean.spring_boot_demo_mvc.web.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.antbean.spring_boot_demo_mvc")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	// 文件上传解析器
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(1000000);
		return commonsMultipartResolver;
	}

	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}

	// 设置静态资源访问
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// addResourceHandler:指对外暴露的访问路径；addResourceLocations:指文件放置的目录(classpath:/assets/和/WEB-INF/classes/assets/相同)
		// registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/classes/assets/");
	}

	// 设置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}

	// 对于没有业务处理逻辑,只是简单的页面转向,如:
	// --> @RequestMapping("/hello")
	// --> public String hello() {
	// --> return "hello";
	// --> }
	// 这样的controller,可以省略,直接在addViewControllers方法中集中管理
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/hello").setViewName("/hello");
		// registry.addRedirectViewController("/baidu", "http://www.baidu.com");
		registry.addViewController("/hello").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");
	}

	// 在SpringMVC中，路径参数如果带“.”的话，“.”后面的值将被忽略，例如：http://localhost:8081/spring-boot-demo-mvc/anno/pathvar/sssssss.aa，
	// 此时“.aa”将被忽略。通过重写configurePathMatch可不忽略“.”及其后面的字符
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}

}
