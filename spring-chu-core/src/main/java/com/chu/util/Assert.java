package com.chu.util;

import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public abstract class Assert {

	public static void notNull(@Nullable Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void hasLength(@Nullable String text, String message) {
		if (!StringUtils.hasLength(text)) {
			throw new IllegalArgumentException(message);
		}
	}
}
