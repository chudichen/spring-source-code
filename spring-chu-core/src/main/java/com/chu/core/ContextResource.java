package com.chu.core;

import com.chu.core.io.Resource;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public interface ContextResource extends Resource {

	String getPathWithContext();
}
