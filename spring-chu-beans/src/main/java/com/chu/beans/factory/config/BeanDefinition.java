package com.chu.beans.factory.config;

import com.chu.beans.BeanMetadataElement;
import com.chu.beans.PropertyValues;

import java.util.Objects;

/**
 * @author chudichen
 * @date 2021-03-30
 */
public class BeanDefinition implements BeanMetadataElement {

	public static final String SCOPE_SINGLETON = "singleton";

	public static final String SCOPE_PROTOTYPE = "prototype";

	private Class<?> beanClass;

	private PropertyValues propertyValues;

	private String initMethodName;

	private String destroyMethodName;

	private String scope;

	private boolean singleton;

	private boolean prototype;

	public BeanDefinition(Class<?> beanClass) {
		this(beanClass, null);
	}

	public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
		this.beanClass = beanClass;
		this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
		// 默认初始值
		this.scope = SCOPE_SINGLETON;
		this.singleton = true;
		this.prototype = false;
	}

	public void setScope(String scope) {
		this.scope = scope;
		this.singleton = SCOPE_SINGLETON.equals(scope);
		this.prototype = SCOPE_PROTOTYPE.equals(scope);
	}

	public boolean isSingleton() {
		return this.singleton;
	}

	public boolean isPrototype() {
		return this.prototype;
	}

	public Class<?> getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}

	public String getInitMethodName() {
		return initMethodName;
	}

	public void setInitMethodName(String initMethodName) {
		this.initMethodName = initMethodName;
	}

	public String getDestroyMethodName() {
		return destroyMethodName;
	}

	public void setDestroyMethodName(String destroyMethodName) {
		this.destroyMethodName = destroyMethodName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BeanDefinition that = (BeanDefinition) o;
		return beanClass.equals(that.beanClass);
	}

	@Override
	public int hashCode() {
		return Objects.hash(beanClass);
	}
}
