package com.chu.beans.factory.support;

import com.chu.beans.BeansException;
import com.chu.beans.factory.ConfigurableListableBeanFactory;
import com.chu.beans.factory.config.BeanDefinition;

import java.util.*;

/**
 * @author chudichen
 * @date 2021-04-02
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	@Override
	public int getBeanDefinitionCount() {
		return 0;
	}

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null) {
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}
		return beanDefinition;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		Map<String, T> result = new HashMap<>();
		beanDefinitionMap.forEach((beanName, beanDefinition) -> {
			Class<?> beanClass = beanDefinition.getBeanClass();
			if (type.isAssignableFrom(beanClass)) {
				T bean = (T) getBean(beanClass);
				result.put(beanName, bean);
			}
		});
		return result;
	}

	@Override
	public boolean containsBeanDefinition(String beanName) {
		return beanDefinitionMap.containsKey(beanName);
	}

	@Override
	public <T> T getBean(Class<T> requiredType) throws BeansException {
		List<String> beanNames = new ArrayList<>();
		for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
			Class<?> beanClass = entry.getValue().getBeanClass();
			if (requiredType.isAssignableFrom(beanClass)) {
				beanNames.add(entry.getKey());
			}
		}
		if (beanNames.size() == 1) {
			return getBean(beanNames.get(0), requiredType);
		}

		throw new BeansException(requiredType + "expected single bean but found " + beanNames.size() + ": " + beanNames);
	}

	@Override
	public String[] getBeanDefinitionNames() {
		Set<String> beanNames = beanDefinitionMap.keySet();
		return beanNames.toArray(new String[0]);
	}

	@Override
	public void preInstantiateSingletons() throws BeansException {
		beanDefinitionMap.forEach(((beanName, beanDefinition) -> {
			if (beanDefinition.isSingleton()) {
				getBean(beanName);
			}
		}));
	}
}
