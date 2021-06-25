package com.chu.beans;

import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-04-16
 */
public interface Mergeable {

	boolean isMergeEnabled();

	Object merge(@Nullable Object parent);
}
