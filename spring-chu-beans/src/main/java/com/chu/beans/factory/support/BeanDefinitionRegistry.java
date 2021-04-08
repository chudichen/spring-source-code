package com.chu.beans.factory.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface BeanDefinitionRegistry {

	/**
	 * 向注册表中注BeanDefinition
	 *
	 * @param beanName       名字
	 * @param beanDefinition 定义
	 */
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

	/**
	 * 根据名称查询BeanDefinition
	 *
	 * @param beanName 名称
	 * @return beanDefinition
	 * @throws BeansException 未找到
	 */
	BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	/**
	 * 是否包含指定名称的BeanDefinition
	 *
	 * @param beanName 名称
	 * @return {@code true}包含
	 */
	boolean containsBeanDefinition(String beanName);

	/**
	 * 返回定义的所有bean的名称
	 *
	 * @return 名称
	 */
	String[] getBeanDefinitionNames();

	/**
	 * beanDefinition数量
	 *
	 * @return 数量
	 */
	int getBeanDefinitionCount();
}
