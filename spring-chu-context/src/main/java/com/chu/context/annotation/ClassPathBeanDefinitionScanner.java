package com.chu.context.annotation;

import cn.hutool.core.lang.Assert;
import com.chu.beans.factory.config.BeanDefinition;
import com.chu.beans.factory.config.BeanDefinitionHolder;
import com.chu.beans.factory.support.BeanDefinitionReaderUtils;
import com.chu.beans.factory.support.BeanDefinitionRegistry;
import com.chu.beans.factory.support.BeanNameGenerator;

import java.util.Set;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

	private static final String AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME = "com.chu.context.annotation.internalAutowiredAnnotationProcessor";

	private BeanDefinitionRegistry registry;

	private final ClassPathScanningCandidateComponentProvider provider;

	private BeanNameGenerator beanNameGenerator = AnnotationBeanNameGenerator.INSTANCE;

	public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		this.registry = registry;
		this.provider = new ClassPathScanningCandidateComponentProvider();
	}

	public int scan(String... basePackages) {
		doScan(basePackages);
		return 0;
	}

	protected Set<BeanDefinition> doScan(String[] basePackages) {
		Assert.notEmpty(basePackages, "At least one base package must be specified");
		Set<BeanDefinition> beanDefinitions = provider.scanCandidateComponents(basePackages);

		beanDefinitions.forEach(beanDefinition -> {
			String beanName = this.beanNameGenerator.generateBeanName(beanDefinition, this.registry);
			BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, beanName);
			registerBeanDefinition(definitionHolder, this.registry);
		});

		return beanDefinitions;
	}

	protected void registerBeanDefinition(BeanDefinitionHolder definitionHolder, BeanDefinitionRegistry registry) {
		BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
	}
}
