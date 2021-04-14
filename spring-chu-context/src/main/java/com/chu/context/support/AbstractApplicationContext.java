package com.chu.context.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.ConfigurableListableBeanFactory;
import com.chu.beans.factory.config.BeanFactoryPostProcessor;
import com.chu.beans.factory.config.BeanPostProcessor;
import com.chu.context.ApplicationEvent;
import com.chu.context.ApplicationListener;
import com.chu.context.ConfigurableApplicationContext;
import com.chu.context.event.ApplicationEventMulticaster;
import com.chu.context.event.ContextRefreshedEvent;
import com.chu.context.event.SimpleApplicationEventMulticaster;
import com.chu.core.convert.ConversionService;
import com.chu.core.env.ConfigurableEnvironment;
import com.chu.core.io.DefaultResourceLoader;
import com.chu.lang.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * 抽象应用上下文
 *
 * @author chudichen
 * @date 2021-04-01
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

	public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

	public static final String CONVERSION_SERVICE_BEAN_NAME = "conversionService";

	private ApplicationEventMulticaster applicationEventMulticaster;

	@Nullable
	private ConfigurableEnvironment environment;

	@Override
	public void refresh() throws BeansException {
		// 创建BeanFactory，并在家BeanDefinition
		refreshBeanFactory();
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();

		// 添加ApplicationContextAwareProcessor，让继承自ApplicationContextAware的bean能感知bean
		beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

		// 在bean实例化之前，执行BeanFactoryPostProcessor
		invokeBeanFactoryPostProcessors(beanFactory);

		// BeanPostProcessor需要提前与其他bean实例胡之前注册
		registerBeanPostProcessors(beanFactory);

		// 初始化时间发布者
		initApplicationEventMulticaster();

		// 注册事件监听器
		registerListeners();

		// 注册类型转换器和提前实例化单例bean
		finishBeanFactoryInitialization(beanFactory);

		// 发布容器刷新完成事件
		finishRefresh();
	}

	public abstract ConfigurableListableBeanFactory getBeanFactory();

	/**
	 * 创建BeanFactory，并加载BeanDefinition
	 *
	 * @throws BeansException 异常
	 */
	protected abstract void refreshBeanFactory() throws BeansException;

	protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {
		// 设置类型转换器
		if (beanFactory.containsBean(CONVERSION_SERVICE_BEAN_NAME)) {
			Object conversionService = beanFactory.getBean(CONVERSION_SERVICE_BEAN_NAME);
			if (conversionService instanceof ConversionService) {
				beanFactory.setConversionService((ConversionService) conversionService);
			}
		}

		// 提前实例化单例bean
		beanFactory.preInstantiateSingletons();
	}

	/**
	 * 在Bean实例化之前，执行BeanFactoryPostProcessors
	 *
	 * @param beanFactory 工厂
	 */
	protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
		for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
			beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
		}
	}

	/**
	 * 注册BeanPostProcessor
	 *
	 * @param beanFactory 工厂
	 */
	protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
		for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
			beanFactory.addBeanPostProcessor(beanPostProcessor);
		}
	}

	/**
	 * 初始化事件发布者
	 */
	protected void initApplicationEventMulticaster() {
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();
		applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
	}

	/**
	 * 注册事件监听器
	 */
	@SuppressWarnings("rawtypes")
	protected void registerListeners() {
		Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
		for (ApplicationListener<?> applicationListener : applicationListeners) {
			applicationEventMulticaster.addApplicationListener(applicationListener);
		}
	}

	/**
	 * 发布容器刷新完成事件
	 */
	protected void finishRefresh() {
		publishEvent(new ContextRefreshedEvent(this));
	}

	@Override
	public void publishEvent(ApplicationEvent event) {
		applicationEventMulticaster.multicastEvent(event);
	}

	@Override
	public boolean containsBean(String name) {
		return getBeanFactory().containsBean(name);
	}

	@Override
	public Object getBean(String name) throws BeansException {
		return getBeanFactory().getBean(name);
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return getBeanFactory().getBean(name, requiredType);
	}

	@Override
	public <T> T getBean(Class<T> requiredType) throws BeansException {
		return getBeanFactory().getBean(requiredType);
	}

	@Override
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		return getBeanFactory().getBeansOfType(type);
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return getBeanFactory().getBeanDefinitionNames();
	}

	public int getBeanDefinitionCount() {
		return 0;
	}

	@Override
	public void close() {
		doClose();
	}

	@Override
	public void registerShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(this::doClose));
	}

	@Nullable
	public ConfigurableEnvironment getEnvironment() {
		return environment;
	}

	protected void doClose() {
		// 发布容器关闭事件
		publishEvent(new ContextRefreshedEvent(this));
		// 执行单例bean的销毁方法
		destroyBeans();
	}

	protected void destroyBeans() {
		getBeanFactory().destroySingletons();
	}
}
