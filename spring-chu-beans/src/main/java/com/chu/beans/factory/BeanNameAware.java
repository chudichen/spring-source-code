package com.chu.beans.factory;

/**
 * 设置beanName
 *
 * @author chudichen
 * @date 2021-04-09
 */
public interface BeanNameAware extends Aware {

	void setBeanName(String name);
}
