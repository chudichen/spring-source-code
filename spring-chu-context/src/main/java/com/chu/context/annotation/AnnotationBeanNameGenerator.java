package com.chu.context.annotation;

import cn.hutool.core.lang.Assert;
import com.chu.beans.factory.config.BeanDefinition;
import com.chu.beans.factory.support.BeanDefinitionRegistry;
import com.chu.beans.factory.support.BeanNameGenerator;
import com.chu.util.ClassUtils;

import java.beans.Introspector;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public class AnnotationBeanNameGenerator implements BeanNameGenerator {

	public static final AnnotationBeanNameGenerator INSTANCE = new AnnotationBeanNameGenerator();

	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		return buildDefaultBeanName(definition, registry);
	}

	protected String buildDefaultBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		return buildDefaultBeanName(definition);
	}

	protected String buildDefaultBeanName(BeanDefinition definition) {
		String beanClassName = definition.getBeanClass().getName();
		Assert.state(beanClassName != null, "No bean class name set");
		String shortClassName = ClassUtils.getShortName(beanClassName);
		return Introspector.decapitalize(shortClassName);
	}
}
