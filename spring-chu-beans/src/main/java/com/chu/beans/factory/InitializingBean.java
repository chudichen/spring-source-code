package com.chu.beans.factory;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public interface InitializingBean {

	void afterPropertiesSet() throws Exception;
}
