package com.chu.context.annotation;

import com.chu.beans.factory.config.BeanDefinition;

/**
 * 处理BeanDefinition的Scope策略
 *
 * @author chudichen
 * @date 2021-04-09
 */
@FunctionalInterface
public interface ScopeMetadataResolver {

	/**
	 * 通过BeanDefinition解析scope
	 *
	 * @param definition 定义
	 * @return scope
	 */
	ScopeMetadata resolveScopeMetadata(BeanDefinition definition);
}
