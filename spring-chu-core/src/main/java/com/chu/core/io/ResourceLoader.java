package com.chu.core.io;

import com.chu.lang.Nullable;
import com.chu.util.ResourceUtils;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public interface ResourceLoader {

	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;

	/**
	 * 根据路径加载资源
	 *
	 * @param location 路径
	 * @return 资源
	 */
	Resource getResource(String location);

	/**
	 * 返回一个类加载器
	 *
	 * @return 类加载器
	 */
	@Nullable
	ClassLoader getClassLoader();
}
