package com.chu.beans;

import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-04-07
 */
public interface BeanMetadataElement {

	/**
	 * 返回配置源
	 *
	 * @return
	 */
	@Nullable
	default Object getSource() {
		return null;
	}
}
