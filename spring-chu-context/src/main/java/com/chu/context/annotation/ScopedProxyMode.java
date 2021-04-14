package com.chu.context.annotation;

/**
 * 代理的Scope策略
 *
 * @author chudichen
 * @date 2021-04-09
 */
public enum ScopedProxyMode {

	/**
	 * 默认策略，等同于{@link #NO}
	 */
	DEFAULT,

	/**
	 * 不使用代理
	 */
	NO,

	/**
	 * 使用JDK代理
	 */
	INTERFACES,

	/**
	 * 使用CGLIB
	 */
	TARGET_CLASS
}
