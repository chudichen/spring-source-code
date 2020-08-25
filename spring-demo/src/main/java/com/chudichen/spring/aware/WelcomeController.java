package com.chudichen.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

/**
 * @author chudichen
 * @date 2020-08-06
 */
public class WelcomeController implements ApplicationContextAware, BeanNameAware {

	private String name;
	private ApplicationContext applicationContext;

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		applicationContext = applicationContext;
	}

	public void test() {
		System.out.println("hello " + name);
	}
}
