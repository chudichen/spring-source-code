package com.chu.beans.factory;

import com.chu.beans.BeansException;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ObjectFactory<T> {

	/**
	 * 获取对象
	 *
	 * @return 对象
	 * @throws BeansException 未找到Bean
	 */
	T getObject() throws BeansException;
}
