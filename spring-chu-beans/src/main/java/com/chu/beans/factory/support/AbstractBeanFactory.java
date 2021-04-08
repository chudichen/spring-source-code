package com.chu.beans.factory.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.FactoryBean;
import com.chu.beans.factory.config.BeanDefinition;
import com.chu.beans.factory.config.BeanPostProcessor;
import com.chu.beans.factory.config.ConfigurableBeanFactory;
import com.chu.core.convert.ConversionService;
import com.chu.util.StringValueResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chudichen
 * @date 2021-04-02
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

	private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

	private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

	private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

	private ConversionService conversionService;

	protected abstract boolean containsBeanDefinition(String beanName);

	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	@Override
	public Object getBean(String name) throws BeansException {
		Object sharedInstance = getSingleton(name);
		if (sharedInstance != null) {
			// 如果是FactoryBean，从FactoryBean#getObject中创建bean
			return getObjectForBeanInstance(sharedInstance, name);
		}

		BeanDefinition beanDefinition = getBeanDefinition(name);
		Object bean = createBean(name, beanDefinition);
		return getObjectForBeanInstance(bean, name);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return (T) getBean(name);
	}

	@Override
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		// 有则覆盖
		this.beanPostProcessors.remove(beanPostProcessor);
		this.beanPostProcessors.add(beanPostProcessor);
	}

	@Override
	public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
		this.embeddedValueResolvers.add(valueResolver);
	}

	@Override
	public String resolveEmbeddedValue(String value) {
		String result = value;
		for (StringValueResolver resolver : this.embeddedValueResolvers) {
			result = resolver.resolveStringValue(result);
		}
		return result;
	}

	@Override
	public void setConversionService(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	@Override
	public ConversionService getConversionService() {
		return conversionService;
	}

	@Override
	public boolean containsBean(String name) {
		return containsBeanDefinition(name);
	}

	public List<BeanPostProcessor> getBeanPostProcessors() {
		return this.beanPostProcessors;
	}

	/**
	 * 如果是FactoryBean，从FactoryBean#getObject中创建bean
	 *
	 * @param beanInstance bean实例
	 * @param beanName bean name
	 * @return 实例
	 */
	protected Object getObjectForBeanInstance(Object beanInstance, String beanName) {
		Object object = beanInstance;
		if (beanInstance instanceof FactoryBean) {
			FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
			try {
				if (factoryBean.isSingleton()) {
					// singleton作用域bean，从缓存中取
					object = this.factoryBeanObjectCache.get(beanName);
					if (object == null) {
						object = factoryBean.getObject();
						this.factoryBeanObjectCache.put(beanName, object);
					}
				} else {
					// prototype作用域bean，新创建bean
					object = factoryBean.getObject();
				}
			} catch (Exception ex) {
				throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", ex);
			}
		}
		return object;
	}
}
