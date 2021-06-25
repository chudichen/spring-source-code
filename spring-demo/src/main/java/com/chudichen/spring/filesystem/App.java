package com.chudichen.spring.filesystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用配置文件来加载Bean
 *
 * @author chudichen
 * @since 2020-10-22
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application.xml");
		Object test = applicationContext.getBean("user");
		System.out.println(test);
	}
}
