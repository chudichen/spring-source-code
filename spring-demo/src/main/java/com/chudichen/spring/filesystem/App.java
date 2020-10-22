package com.chudichen.spring.filesystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author chudichen
 * @since 2020-10-22
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext();
		Object test = applicationContext.getBean("test");
		System.out.println(test);
	}
}
