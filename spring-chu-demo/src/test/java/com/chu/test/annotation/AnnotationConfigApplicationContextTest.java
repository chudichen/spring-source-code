package com.chu.test.annotation;

import com.chu.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.Test;


/**
 * @author chudichen
 * @date 2021-04-07
 */
public class AnnotationConfigApplicationContextTest {

	@Test
	public void annotationTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.chu.test.annotation");
		User bean = context.getBean(User.class);
		bean.say();
	}
}
