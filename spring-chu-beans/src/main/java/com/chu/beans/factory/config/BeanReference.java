package com.chu.beans.factory.config;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class BeanReference {

	private final String beanName;

	public BeanReference(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return this.beanName;
	}
}
