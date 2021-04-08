package com.chu.context.annotation;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public interface AnnotationConfigRegistry {

	/**
	 * 注册bean
	 *
	 * @param componentClasses 需要注册的bean
	 */
	void register(Class<?>... componentClasses);

	/**
	 * 扫描注入
	 *
	 * @param basePackages 基础包
	 */
	void scan(String... basePackages);
}
