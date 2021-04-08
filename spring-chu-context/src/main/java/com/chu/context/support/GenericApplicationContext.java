package com.chu.context.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.ConfigurableListableBeanFactory;
import com.chu.beans.factory.config.BeanDefinition;
import com.chu.beans.factory.support.BeanDefinitionRegistry;
import com.chu.beans.factory.support.DefaultListableBeanFactory;
import com.chu.core.io.ResourceLoader;
import com.chu.lang.Nullable;
import com.chu.util.Assert;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class GenericApplicationContext extends AbstractApplicationContext implements BeanDefinitionRegistry {

	private final DefaultListableBeanFactory beanFactory;

	@Nullable
	private ResourceLoader resourceLoader;

	private boolean customClassLoader = false;

	private final AtomicBoolean refreshed = new AtomicBoolean();


	public GenericApplicationContext() {
		this.beanFactory = new DefaultListableBeanFactory();
	}

	public GenericApplicationContext(DefaultListableBeanFactory beanFactory) {
		Assert.notNull(beanFactory, "BeanFactory must not be null");
		this.beanFactory = beanFactory;
	}

	/**
	 * 只加载一次
	 *
	 * @throws BeansException 异常
	 */
	@Override
	protected void refreshBeanFactory() throws BeansException {
		if (!this.refreshed.compareAndSet(false, true)) {
			throw new IllegalStateException(
					"GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once");
		}
	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory() {
		return this.beanFactory;
	}

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		this.beanFactory.registerBeanDefinition(beanName, beanDefinition);
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		return this.beanFactory.getBeanDefinition(beanName);
	}

	@Override
	public boolean containsBeanDefinition(String beanName) {
		return this.beanFactory.containsBeanDefinition(beanName);
	}
}
