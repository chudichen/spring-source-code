package com.chu.core.io;

import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-03-31
 */
@FunctionalInterface
public interface ProtocolResolver {

	/**
	 * 使用指定加载器加载指定路径
	 *
	 * @param location 路径
	 * @param resourceLoader 加载器
	 * @return 资源
	 */
	@Nullable
	Resource resolve(String location, ResourceLoader resourceLoader);
}
