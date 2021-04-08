package com.chu.context;

import com.chu.beans.BeansException;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

	/**
	 * 刷新容器
	 *
	 * @throws BeansException 异常
	 */
	void refresh() throws BeansException;

	/**
	 * 关闭上下文
	 */
	void close();

	/**
	 * 向虚拟机中注册一个钩子方法，在虚拟机关闭之前执行关闭容器操作
	 */
	void registerShutdownHook();
}
