package com.chu.context.annotation;

import com.chu.beans.factory.support.BeanDefinitionRegistry;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public class AnnotatedBeanDefinitionReader {

	private final BeanDefinitionRegistry registry;

	private ConditionEvaluator conditionEvaluator;

	public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}
}
