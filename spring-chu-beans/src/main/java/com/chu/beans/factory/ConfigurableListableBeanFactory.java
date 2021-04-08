package com.chu.beans.factory;

import com.chu.beans.BeansException;
import com.chu.beans.factory.config.AutowireCapableBeanFactory;
import com.chu.beans.factory.config.BeanDefinition;
import com.chu.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

	/**
	 * 根据名称查询BeanDefinition
	 *
	 * @param beanName 名称
	 * @return bean
	 * @throws BeansException 异常
	 */
	BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	/**
	 * 提前实例化所有单例实例
	 *
	 * @throws BeansException 异常
	 */
	void preInstantiateSingletons() throws BeansException;
}
