package com.chudichen.spring.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chudichen
 * @date 2020-08-04
 */
public class FactoryBeanApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan(FactoryBeanApp.class.getPackage().getName());
		applicationContext.refresh();
		User user = applicationContext.getBean(User.class);
		user.sayHell();
	}
}
