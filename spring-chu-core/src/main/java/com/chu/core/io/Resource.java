package com.chu.core.io;

import java.io.IOException;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public interface Resource extends InputStreamSource {

	boolean exists();

	default boolean isReadable() {
		return exists();
	}

	/**
	 * 通过相对路径创建
	 *
	 * @param relativePath 相对路径
	 * @return 资源
	 * @throws IOException 异常
	 */
	Resource createRelative(String relativePath) throws IOException;

}
