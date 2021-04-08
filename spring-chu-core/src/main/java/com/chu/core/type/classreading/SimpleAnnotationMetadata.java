package com.chu.core.type.classreading;

import com.chu.core.type.AnnotationMetadata;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class SimpleAnnotationMetadata implements AnnotationMetadata {

	@Override
	public String getClassName() {
		return null;
	}

	@Override
	public boolean isInterface() {
		return false;
	}

	@Override
	public boolean isAnnotation() {
		return false;
	}

	@Override
	public boolean isAbstract() {
		return false;
	}

	@Override
	public boolean isFinal() {
		return false;
	}

	@Override
	public boolean isIndependent() {
		return false;
	}

	@Override
	public String getEnclosingClassName() {
		return null;
	}

	@Override
	public String getSuperClassName() {
		return null;
	}

	@Override
	public String[] getInterfaceName() {
		return new String[0];
	}

	@Override
	public String[] getMemberClassNames() {
		return new String[0];
	}
}
