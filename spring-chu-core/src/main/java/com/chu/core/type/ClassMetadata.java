package com.chu.core.type;

import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ClassMetadata {

	String getClassName();

	boolean isInterface();

	boolean isAnnotation();

	boolean isAbstract();

	default boolean isConcrete() {
		return !(isInterface() || isAbstract());
	}

	boolean isFinal();

	boolean isIndependent();

	@Nullable
	String getEnclosingClassName();

	default boolean hasEnclosingClass() {
		return getEnclosingClassName() != null;
	}

	@Nullable
	String getSuperClassName();

	default boolean hasSuperClass() {
		return getSuperClassName() != null;
	}

	String[] getInterfaceName();

	String[] getMemberClassNames();
}
