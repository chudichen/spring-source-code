package com.chudichen.spring.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chudichen
 * @date 2021-02-04
 */
public class AspectJTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.chudichen.spring.aop");
		applicationContext.start();
		TestBean bean = applicationContext.getBean(TestBean.class);
		String result = bean.getTestStr();
		System.out.println(result);
	}
}
