package com.chu.context.annotation;

import com.chu.beans.factory.ConfigurableListableBeanFactory;
import com.chu.beans.factory.support.BeanDefinitionRegistry;
import com.chu.core.env.Environment;
import com.chu.core.io.ResourceLoader;
import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-04-16
 */
public interface ConditionContext {

	BeanDefinitionRegistry getRegistry();

	@Nullable
	ConfigurableListableBeanFactory getBeanFactory();

	Environment getEnvironment();

	ResourceLoader getResourceLoader();

	@Nullable
	ClassLoader getClassLoader();
}
