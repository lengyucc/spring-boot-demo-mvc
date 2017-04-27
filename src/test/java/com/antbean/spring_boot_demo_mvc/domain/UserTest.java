package com.antbean.spring_boot_demo_mvc.domain;

public class UserTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("111222");
		System.out.println(user);
	}
}
