package com.chu.beans.factory.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.config.BeanDefinition;

/**
 * Bean的实例化策略
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface InstantiationStrategy {

	/**
	 * 实例化bean
	 *
	 * @param beanDefinition 定义
	 * @return bean
	 * @throws BeansException 失败
	 */
	Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
