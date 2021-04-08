package com.chu.core.type.classreading;

import com.chu.core.io.DefaultResourceLoader;
import com.chu.core.io.Resource;
import com.chu.core.io.ResourceLoader;
import com.chu.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public class SimpleMetadataReaderFactory implements MetadataReaderFactory {

	private final ResourceLoader resourceLoader;

	public SimpleMetadataReaderFactory() {
		this.resourceLoader = new DefaultResourceLoader();
	}

	@Override
	public MetadataReader getMetadataReader(String className) throws IOException {
		try {
			String resourcePath = ResourceLoader.CLASSPATH_URL_PREFIX +
					ClassUtils.convertClassNameToResourcePath(className) + ClassUtils.CLASS_FILE_SUFFIX;
			Resource resource = this.resourceLoader.getResource(resourcePath);
			return getMetadataReader(resource);
		} catch (FileNotFoundException ex) {
			int lastDotIndex = className.lastIndexOf('.');
			if (lastDotIndex != -1) {
				String innerClassName = className.substring(0, lastDotIndex) + '$' + className.substring(lastDotIndex + 1);
				String innerClassResourcePath = ResourceLoader.CLASSPATH_URL_PREFIX +
						ClassUtils.convertClassNameToResourcePath(innerClassName) + ClassUtils.CLASS_FILE_SUFFIX;
				Resource innerClassResource = this.resourceLoader.getResource(innerClassResourcePath);
				if (innerClassResource.exists()) {
					return getMetadataReader(innerClassResource);
				}
			}
			throw ex;
		}
	}

	@Override
	public MetadataReader getMetadataReader(Resource resource) throws IOException {
		return new SimpleMetadataReader(resource, this.resourceLoader.getClassLoader());
	}
}
