package com.chu.beans.factory;

import com.chu.beans.BeansException;

/**
 * 实现该接口，能感知所属BeanFactory
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface BeanFactoryAware extends Aware {

	/**
	 * 设置bean工厂
	 *
	 * @param beanFactory 工厂
	 * @throws BeansException 未找到bean
	 */
	void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
