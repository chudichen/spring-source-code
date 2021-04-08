package com.chu.beans.factory.config;

import com.chu.beans.BeansException;
import com.chu.beans.factory.BeanFactory;

/**
 * 自动注入工厂
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

	/**
	 * 执行BeanPostProcessors的postProcessBeforeInitialization方法
	 *
	 * @param existingBean 存在的bean
	 * @param beanName     名字
	 * @return bean
	 * @throws BeansException 未找到
	 */
	Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

	/**
	 * 执行BeanPostProcessors的postProcessAfterInitialization方法
	 *
	 * @param existingBean 存在的bean
	 * @param beanName     名字
	 * @return bean
	 * @throws BeansException 未找到
	 */
	Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
