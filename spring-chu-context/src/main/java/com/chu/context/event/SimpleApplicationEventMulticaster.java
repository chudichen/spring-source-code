package com.chu.context.event;

import com.chu.beans.BeansException;
import com.chu.beans.factory.BeanFactory;
import com.chu.context.ApplicationEvent;
import com.chu.context.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

	public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
		setBeanFactory(beanFactory);
	}

	@Override
	public void multicastEvent(ApplicationEvent event) {
		for (ApplicationListener<ApplicationEvent> applicationListener : applicationListeners) {
			if (supportsEvent(applicationListener, event)) {
				applicationListener.onApplicationEvent(event);
			}
		}
	}

	/**
	 * 监听器是否对该时间感兴趣
	 *
	 * @param applicationListener 监听器
	 * @param event 时间
	 * @return 是否支持
	 */
	protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
		Type type = applicationListener.getClass().getGenericInterfaces()[0];
		Type actualTypeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
		String className = actualTypeArgument.getTypeName();
		Class<?> eventClassName;
		try {
			eventClassName = Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new BeansException("wrong event class name: " + className);
		}
		//noinspection ClassGetClass
		return eventClassName.isAssignableFrom(eventClassName.getClass());
	}
}
