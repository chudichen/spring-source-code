package com.chudichen.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chudichen
 * @date 2020-07-30
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
		ServiceImpl serviceImpl = applicationContext.getBean(ServiceImpl.class);
		serviceImpl.sayHello();
	}
}