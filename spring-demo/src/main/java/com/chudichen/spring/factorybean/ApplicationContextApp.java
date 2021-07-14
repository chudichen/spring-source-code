package com.chudichen.spring.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chudichen
 * @date 2020-08-04
 */
public class ApplicationContextApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextApp.class.getPackage().getName());
		User user = applicationContext.getBean(User.class);
		user.sayHell();
	}
}
