package com.chu.core.annotation;

import com.chu.lang.Nullable;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface MergedAnnotation<A extends Annotation> {

	String VALUE = "value";

	Class<A> getType();

	boolean isPresent();

	boolean isDirectlyPresent();

	boolean isMetaPresent();

	int getDistance();

	int getAggregateIndex();

	@Nullable
	Object getSource();

	@Nullable
	MergedAnnotation<?> getMetaSource();

	MergedAnnotation<?> getRoot();

	List<Class<? extends Annotation>> getMetaTypes();

	boolean hasNonDefaultValue(String attributeName);

	boolean hasDefaultValue(String attributeName) throws NoSuchElementException;

	byte getByte(String attributeName) throws NoSuchElementException;
}
