package com.chu.beans.factory;

import com.chu.beans.BeansException;

import java.util.Map;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ListableBeanFactory extends BeanFactory {

	/**
	 * 返回指定类型的所有实例
	 *
	 * @param type 类型
	 * @param <T> 泛型
	 * @return 类型
	 * @throws BeansException 未找到
	 */
	<T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

	/**
	 * 返回定义的所有bean的名称
	 *
	 * @return 名称
	 */
	String[] getBeanDefinitionNames();
}
