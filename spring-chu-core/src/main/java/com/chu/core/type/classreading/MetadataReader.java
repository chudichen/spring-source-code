package com.chu.core.type.classreading;

import com.chu.core.io.Resource;
import com.chu.core.type.AnnotationMetadata;
import com.chu.core.type.ClassMetadata;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public interface MetadataReader {

	Resource getResource();

	ClassMetadata getClassMetadata();

	AnnotationMetadata getAnnotationMetadata();
}
