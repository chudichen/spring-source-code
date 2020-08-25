package com.chudichen.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chudichen
 * @date 2020-07-30
 */
public class AwareApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan(AwareApp.class.getPackage().getName());
		applicationContext.refresh();
		WelcomeController welcomeController = applicationContext.getBean(WelcomeController.class);
		welcomeController.test();
	}
}