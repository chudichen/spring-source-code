package com.chu.core.type.classreading;

import com.chu.core.io.Resource;

import java.io.IOException;

/**
 * 工厂接口
 *
 * @author chudichen
 * @date 2021-03-31
 */
public interface MetadataReaderFactory {

	/**
	 * 通过类名获取 MetadataReader
	 *
	 * @param className 类名
	 * @return 元数据读取器
	 * @throws IOException 异常
	 */
	MetadataReader getMetadataReader(String className) throws IOException;

	/**
	 * 通过资源获取 MetadataReader
	 *
	 * @param resource 资源
	 * @return 元数据读取器
	 * @throws IOException 异常
	 */
	MetadataReader getMetadataReader(Resource resource) throws IOException;
}
