package com.chu.beans.factory;

/**
 * @author chudichen
 * @date 2021-04-02
 */
public interface FactoryBean<T> {

	T getObject() throws Exception;

	boolean isSingleton();
}
