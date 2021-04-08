package com.chu.beans.factory.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author chudichen
 * @date 2021-04-06
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

	/**
	 * 简单的bean实例化策略，根据bean的无参构造函数实例化对象
	 *
	 * @param beanDefinition 定义
	 * @return 实例
	 * @throws BeansException 异常
	 */
	@Override
	public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
		Class<?> beanClass = beanDefinition.getBeanClass();
		try {
			Constructor<?> constructor = beanClass.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
		}
	}
}
