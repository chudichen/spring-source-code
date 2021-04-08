package com.chu.context;

import com.chu.beans.BeansException;
import com.chu.beans.factory.Aware;

/**
 * 实现该接口，能感知所属ApplicationContxt
 *
 * @author chudichen
 * @date 2021-04-07
 */
public interface ApplicationContextAware extends Aware {

	/**
	 * 设置应用上下文
	 *
	 * @param applicationContext 上下文
	 * @throws BeansException 异常
	 */
	void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
