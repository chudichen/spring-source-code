package com.chu.beans.factory.support;

import cn.hutool.core.util.ClassUtil;
import com.chu.beans.BeansException;
import com.chu.beans.factory.DisposableBean;
import com.chu.beans.factory.config.BeanDefinition;
import com.chu.util.ClassUtils;
import com.chu.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @author chudichen
 * @date 2021-04-06
 */
public class DisposableBeanAdapter implements DisposableBean {

	private static final String DESTROY_METHOD = "destroy";

	private final Object bean;

	private final String beanName;

	private final String destroyMethodName;

	public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
		this.bean = bean;
		this.beanName = beanName;
		this.destroyMethodName = beanDefinition.getDestroyMethodName();
	}

	@Override
	public void destroy() throws Exception {
		if (bean instanceof DisposableBean) {
			((DisposableBean) bean).destroy();
		}

		// 避免同时继承自DisposableBean，且自定义方法与DisposableBean方法同名，销毁方法执行两次的情况
		if (StringUtils.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && DESTROY_METHOD.equals(this.destroyMethodName))) {
			// 执行自定义方法
			Method destroyMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
			if (destroyMethod == null) {
				throw new BeansException("Could't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
			}
			destroyMethod.invoke(bean);
		}
	}
}
