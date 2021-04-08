package com.chu.core.type.classreading;

import com.chu.core.io.Resource;
import com.chu.core.type.AnnotationMetadata;
import com.chu.core.type.ClassMetadata;
import com.chu.lang.Nullable;

import java.io.IOException;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class SimpleMetadataReader implements MetadataReader {

	private final Resource resource;

	private final AnnotationMetadata annotationMetadata;

	SimpleMetadataReader(Resource resource, @Nullable ClassLoader classLoader) throws IOException {
		SimpleAnnotationMetadataReadingVisitor visitor = new SimpleAnnotationMetadataReadingVisitor();

		this.resource = resource;
		this.annotationMetadata = visitor.getMetadata();
	}

	@Override
	public ClassMetadata getClassMetadata() {
		return null;
	}

	@Override
	public AnnotationMetadata getAnnotationMetadata() {
		return null;
	}

	@Override
	public Resource getResource() {
		return this.resource;
	}
}
