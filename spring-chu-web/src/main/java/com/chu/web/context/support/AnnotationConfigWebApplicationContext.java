package com.chu.web.context.support;

import cn.hutool.core.lang.Assert;
import com.chu.beans.factory.support.BeanNameGenerator;
import com.chu.beans.factory.support.DefaultListableBeanFactory;
import com.chu.context.annotation.AnnotatedBeanDefinitionReader;
import com.chu.context.annotation.AnnotationConfigRegistry;
import com.chu.context.annotation.ClassPathBeanDefinitionScanner;
import com.chu.context.annotation.ScopeMetadataResolver;
import com.chu.lang.Nullable;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author chudichen
 * @date 2021-04-09
 */
public class AnnotationConfigWebApplicationContext extends AbstractRefreshableWebApplicationContext implements AnnotationConfigRegistry {

	@Nullable
	private BeanNameGenerator beanNameGenerator;

	@Nullable
	private ScopeMetadataResolver scopeMetadataResolver;

	private final Set<Class<?>> componentClasses = new LinkedHashSet<>();

	private final Set<String> basePackages = new LinkedHashSet<>();


	@Nullable
	public BeanNameGenerator getBeanNameGenerator() {
		return beanNameGenerator;
	}

	public void setBeanNameGenerator(@Nullable BeanNameGenerator beanNameGenerator) {
		this.beanNameGenerator = beanNameGenerator;
	}

	@Nullable
	public ScopeMetadataResolver getScopeMetadataResolver() {
		return scopeMetadataResolver;
	}

	public void setScopeMetadataResolver(@Nullable ScopeMetadataResolver scopeMetadataResolver) {
		this.scopeMetadataResolver = scopeMetadataResolver;
	}

	@Override
	public void register(Class<?>... componentClasses) {
		Assert.notEmpty(componentClasses, "At least one component class must be specified");
		Collections.addAll(this.componentClasses, componentClasses);
	}

	@Override
	public void scan(String... basePackages) {
		Assert.notEmpty(basePackages, "At least one base package must be specified");
		Collections.addAll(this.basePackages, basePackages);
	}

	private AnnotatedBeanDefinitionReader getAnnotatedBeanDefinitionReader(DefaultListableBeanFactory beanFactory) {
		return new AnnotatedBeanDefinitionReader(beanFactory, getEnvironment());
	}

	private ClassPathBeanDefinitionScanner getClassPathBeanDefinitionScanner(DefaultListableBeanFactory beanFactory) {
		return new ClassPathBeanDefinitionScanner(beanFactory, toString(), getEnvironment());
	}
}
