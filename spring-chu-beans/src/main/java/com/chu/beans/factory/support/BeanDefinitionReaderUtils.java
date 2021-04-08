package com.chu.beans.factory.support;

import com.chu.beans.factory.BeanFactoryUtils;
import com.chu.beans.factory.config.BeanDefinitionHolder;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public abstract class BeanDefinitionReaderUtils {

	public static final String GENERATED_BEAN_NAME_SEPARATOR = BeanFactoryUtils.GENERATED_BEAN_NAME_SEPARATOR;


	public static void registerBeanDefinition(
			BeanDefinitionHolder definitionHolder, BeanDefinitionRegistry registry) {
		String beanName = definitionHolder.getBeanName();
		registry.registerBeanDefinition(beanName, definitionHolder.getBeanDefinition());
	}
}
