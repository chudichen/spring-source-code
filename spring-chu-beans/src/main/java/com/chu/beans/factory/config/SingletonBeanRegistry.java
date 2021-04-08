package com.chu.beans.factory.config;

/**
 * 单例注册表
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface SingletonBeanRegistry {

	/**
	 * 获取单例对象
	 *
	 * @param beanName 名字
	 * @return bean
	 */
	Object getSingleton(String beanName);

	/**
	 * 获取单例对象
	 *
	 * @param beanName        名字
	 * @param singletonObject bean
	 */
	void addSingleton(String beanName, Object singletonObject);
}
