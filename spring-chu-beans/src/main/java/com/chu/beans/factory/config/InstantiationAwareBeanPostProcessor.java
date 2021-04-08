package com.chu.beans.factory.config;

import com.chu.beans.BeansException;
import com.chu.beans.PropertyValues;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

	/**
	 * 在bean实例化之前执行
	 *
	 * @param beanClass 类
	 * @param beanName 名称
	 * @return 处理后
	 */
	Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName);

	/**
	 * bean实例化之后，设置属性之前执行
	 *
	 * @param bean bean
	 * @param beanName 名字
	 * @return 处理后对象
	 * @throws BeansException 异常
	 */
	boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

	/**
	 * bean实例化之后，设置属性之前执行
	 *
	 * @param pvs 属性
	 * @param bean bean
	 * @param beanName 名称
	 * @return 处理后对象
	 * @throws BeansException 异常
	 */
	PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

	/**
	 * 提前暴露bean
	 *
	 * @param bean bean
	 * @param beanName 名称
	 * @return 处理后对象
	 * @throws BeansException 异常
	 */
	default Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
