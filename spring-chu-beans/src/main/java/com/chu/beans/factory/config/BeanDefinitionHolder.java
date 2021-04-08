package com.chu.beans.factory.config;

import com.chu.beans.BeanMetadataElement;
import com.chu.beans.factory.BeanFactoryUtils;
import com.chu.lang.Nullable;
import com.chu.util.Assert;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public class BeanDefinitionHolder implements BeanMetadataElement {

	private final BeanDefinition beanDefinition;

	private final String beanName;

	@Nullable
	private final String[] aliases;

	public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName) {
		this(beanDefinition, beanName, null);
	}


	public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName, @Nullable String[] aliases) {
		Assert.notNull(beanDefinition, "BeanDefinition must not be null");
		Assert.notNull(beanName, "Bean name must not be null");
		this.beanDefinition = beanDefinition;
		this.beanName = beanName;
		this.aliases = aliases;
	}

	public BeanDefinitionHolder(BeanDefinitionHolder beanDefinitionHolder) {
		Assert.notNull(beanDefinitionHolder, "BeanDefinitionHolder must not be null");
		this.beanDefinition = beanDefinitionHolder.getBeanDefinition();
		this.beanName = beanDefinitionHolder.getBeanName();
		this.aliases = beanDefinitionHolder.getAliases();
	}

	public BeanDefinition getBeanDefinition() {
		return this.beanDefinition;
	}

	public String getBeanName() {
		return this.beanName;
	}

	@Nullable
	public String[] getAliases() {
		return this.aliases;
	}

	@Override
	@Nullable
	public Object getSource() {
		return this.beanDefinition.getSource();
	}
}
