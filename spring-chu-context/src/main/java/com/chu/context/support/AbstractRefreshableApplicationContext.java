package com.chu.context.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.ConfigurableListableBeanFactory;
import com.chu.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

	private DefaultListableBeanFactory beanFactory;

	/**
	 * 创建beanFactory并加载BeanDefinition
	 *
	 * @throws BeansException 异常
	 */
	@Override
	protected void refreshBeanFactory() throws BeansException {
		DefaultListableBeanFactory beanFactory = createBeanFactory();
	}

	@Override
	public DefaultListableBeanFactory getBeanFactory() {
		return beanFactory;
	}

	/**
	 * 加载BeanDefinition
	 *
	 * @param beanFactory 工厂
	 * @throws BeansException 异常
	 */
	protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

	/**
	 * 创建bean工厂
	 *
	 * @return bean工厂
	 */
	protected DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactory();
	}
}
