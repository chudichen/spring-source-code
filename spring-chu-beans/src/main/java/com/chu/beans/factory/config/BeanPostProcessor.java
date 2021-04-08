package com.chu.beans.factory.config;

import com.chu.beans.BeansException;

/**
 * 用于修改实例化后的bean的修改扩展点
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface BeanPostProcessor {

	/**
	 * 在bean执行初始化方法之前执行此方法
	 *
	 * @param bean     bean
	 * @param beanName name
	 * @return result
	 * @throws BeansException 异常
	 */
	Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

	/**
	 * 在bean执行初始化方法之后执行此方法
	 *
	 * @param bean     bean
	 * @param beanName name
	 * @return result
	 * @throws BeansException 异常
	 */
	Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}

