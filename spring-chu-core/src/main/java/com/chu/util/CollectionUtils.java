package com.chu.util;

import com.chu.lang.Nullable;

import java.util.Collection;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public abstract class CollectionUtils {

	public static boolean isEmpty(@Nullable Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}
}
