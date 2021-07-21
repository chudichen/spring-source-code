package com.chudichen.spring.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chudichen
 * @date 2021-02-04
 */
public class AspectJTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBeanA.class.getPackage().getName());
		GetStr bean = (GetStr) applicationContext.getBean("testBeanA");
		String result = bean.getTestStr();
		result = bean.getTestStr();
		System.out.println(result);
	}
}
