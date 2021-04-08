package com.chu.beans.factory.support;

import com.chu.beans.factory.config.BeanDefinition;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public interface BeanNameGenerator {


	/**
	 * 使用beanDefinition产生bean名字
	 *
	 * @param definition 定义
	 * @param registry 注册
	 * @return beanName
	 */
	String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry);
}
