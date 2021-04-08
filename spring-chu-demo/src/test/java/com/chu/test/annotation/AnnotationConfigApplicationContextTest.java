package com.chu.test.annotation;

import com.chu.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public class AnnotationConfigApplicationContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.chu.test.annotation");
		User bean = context.getBean(User.class);
		bean.say();
	}
}
