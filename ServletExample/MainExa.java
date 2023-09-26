package com.infinite.maven;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainExa {

	public static void main(String[] arg) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Sample.xml");
		DateExa customer = (DateExa) context.getBean("custAddress1");
		System.out.println(customer.getName());
		System.out.println(customer.getCity());
		System.out.println(customer.getDate());
		
		context.registerShutdownHook();
	}
}