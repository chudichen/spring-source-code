package com.chu.context.annotation;

import com.chu.beans.factory.ConfigurableListableBeanFactory;
import com.chu.beans.factory.support.BeanDefinitionRegistry;
import com.chu.context.ConfigurableApplicationContext;
import com.chu.core.env.Environment;
import com.chu.core.io.ResourceLoader;
import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-04-16
 */
public class ConditionEvaluator {

	private final ConditionContextImpl context;

	public ConditionEvaluator(@Nullable BeanDefinitionRegistry registry,
							  @Nullable Environment environment, @Nullable ResourceLoader resourceLoader) {
		this.context = new ConditionContextImpl();
	}



	private static class ConditionContextImpl implements ConditionContext {

		@Nullable
		private final BeanDefinitionRegistry registry;

		@Nullable
		private final ConfigurableListableBeanFactory beanFactory;

		private final Environment environment;

		private final ResourceLoader resourceLoader;

		@Nullable
		private final ClassLoader classLoader;

		public ConditionContextImpl(@Nullable BeanDefinitionRegistry registry,
									@Nullable Environment environment, @Nullable ResourceLoader resourceLoader) {
			this.registry = registry;
			this.beanFactory = deduceBeanFactory(registry);
			this.environment = environment != null ? environment : deduceEnvironment(registry);
			this.resourceLoader = resourceLoader == null ? deduceResourceLoader(registry) : resourceLoader;
			this.classLoader = deduceClassLoader(resourceLoader, this.beanFactory);
		}

		@Nullable
		private ConfigurableListableBeanFactory deduceBeanFactory(@Nullable BeanDefinitionRegistry source) {
			if (source instanceof ConfigurableListableBeanFactory) {
				return (ConfigurableListableBeanFactory) source;
			}
			if (source instanceof ConfigurableApplicationContext) {
				return ((ConfigurableApplicationContext) source).getBeanFactory();
			}
			return null;
		}

		private Environment deduceEnvironment(@Nullable BeanDefinitionRegistry source) {
			if (source instanceof EnvironmentCapable) {
				return (EnvironmentCapable)
			}
		}


	}
}
