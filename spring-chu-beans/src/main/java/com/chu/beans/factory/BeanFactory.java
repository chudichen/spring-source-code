package com.chu.beans.factory;

import com.chu.beans.BeansException;

/**
 * bean容器
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface BeanFactory {

	/**
	 * 获取bean
	 *
	 * @param name 名称
	 * @return 对象
	 * @throws BeansException bean不存在
	 */
	Object getBean(String name) throws BeansException;

	/**
	 * 根据名称和类型查找bean
	 *
	 * @param name 名称
	 * @param requiredType 要求类型
	 * @param <T> 泛型
	 * @return bean
	 * @throws BeansException 查询不到
	 */
	<T> T getBean(String name, Class<T> requiredType) throws BeansException;

	/**
	 * 根据名称和类型查找bean
	 *
	 * @param requiredType 要求类型
	 * @param <T> 泛型
	 * @return bean
	 * @throws BeansException 查询不到
	 */
	<T> T getBean(Class<T> requiredType) throws BeansException;

	/**
	 * 是否包含该bean
	 *
	 * @param name 名称
	 * @return {@code true} 表示包含
	 */
	boolean containsBean(String name);
}
