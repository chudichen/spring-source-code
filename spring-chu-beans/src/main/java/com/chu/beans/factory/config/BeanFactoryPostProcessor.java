package com.chu.beans.factory.config;

import com.chu.beans.BeansException;
import com.chu.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改BeanDefinition的属性值
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface BeanFactoryPostProcessor {

	/**
	 * 在所有BeanDefinition加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
	 *
	 * @param beanFactory 工厂
	 * @throws BeansException 未找到
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
