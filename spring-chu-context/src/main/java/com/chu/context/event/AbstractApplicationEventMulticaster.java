package com.chu.context.event;

import com.chu.beans.BeansException;
import com.chu.beans.factory.BeanFactory;
import com.chu.beans.factory.BeanFactoryAware;
import com.chu.context.ApplicationEvent;
import com.chu.context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

	protected final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addApplicationListener(ApplicationListener<?> listener) {
		applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
	}

	@Override
	public void removeApplicationListener(ApplicationListener<?> listener) {
		applicationListeners.remove(listener);
	}
}
