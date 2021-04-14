package com.chu.context.annotation;

import com.chu.beans.factory.config.BeanDefinition;
import com.chu.util.Assert;

/**
 * beanDefinition的代理策略
 *
 * @author chudichen
 * @date 2021-04-09
 */
public class ScopeMetadata {

	private String scopeName = BeanDefinition.SCOPE_SINGLETON;

	private ScopedProxyMode scopedProxyMode = ScopedProxyMode.NO;

	/**
	 * 设置scope的名称
	 *
	 * @param scopeName scope名称
	 */
	public void setScopeName(String scopeName) {
		Assert.notNull(scopeName, "'scopeName' must not be null");
		this.scopeName = scopeName;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopedProxyMode(ScopedProxyMode scopedProxyMode) {
		Assert.notNull(scopedProxyMode, "'scopedProxyMode' must not be null");
		this.scopedProxyMode = scopedProxyMode;
	}

	public ScopedProxyMode getScopedProxyMode() {
		return scopedProxyMode;
	}
}
