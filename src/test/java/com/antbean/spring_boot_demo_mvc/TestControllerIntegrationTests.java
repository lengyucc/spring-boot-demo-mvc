package com.antbean.spring_boot_demo_mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.antbean.spring_boot_demo_mvc.config.SpringMvcConfig;
import com.antbean.spring_boot_demo_mvc.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringMvcConfig.class })
@WebAppConfiguration("src/main/resources") // 声明加载的ApplicationContext是一个WebApplicationContext,它的
											// 属性指定了web资源的位置,默认是“src/main/webapp”,本例修改为“src/main/resources”
public class TestControllerIntegrationTests {

	private MockMvc mockMvc; // MockMvc模拟MVC对象通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化
	@Autowired
	private DemoService demoService;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockHttpSession session; // 注入模拟的HttpSession对象
	@Autowired
	private MockHttpServletRequest request; // 注入模拟的HttpServletRequest对象

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testNormalController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/normal")) // 模拟get请求
				.andExpect(MockMvcResultMatchers.status().isOk()) // 预期返回状态为200
				.andExpect(MockMvcResultMatchers.view().name("page")) // 预期view的name为page
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp")) // 预期页面转向的真正路径为/WEB-INF/classes/views/page.jsp
				.andExpect(MockMvcResultMatchers.model().attribute("msg", demoService.saySomething())); // 预期model里的值是demoService.saySomething()返回值hello
	}

	@Test
	public void testRestController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/testRest")) //
				.andExpect(MockMvcResultMatchers.status().isOk()) //
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8")) // 预期返回值的媒体类型为text/plain;charset=UTF-8
				.andExpect(MockMvcResultMatchers.content().string(demoService.saySomething())); // 预期返回值得内容为demoService.saySomething()返回值hello
	}

}
