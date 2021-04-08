package com.chu.core.type.filter;

import com.chu.core.type.classreading.MetadataReader;
import com.chu.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface TypeFilter {

	/**
	 * 判断filter是否属于给定的metadata
	 *
	 * @param metadataReader metadata
	 * @param metadataReaderFactory factory
	 * @return {@code true} 属于
	 * @throws IOException 异常
	 */
	boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException;
}
