package com.chu.context;

import java.util.EventObject;

/**
 * 事件
 *
 * @author chudichen
 * @date 2021-04-01
 */
public abstract class ApplicationEvent extends EventObject {

	private static final long serialVersionUID = -5976193538568875780L;

	public ApplicationEvent(Object source) {
		super(source);
	}
}
