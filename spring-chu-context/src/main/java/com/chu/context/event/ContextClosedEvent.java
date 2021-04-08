package com.chu.context.event;

import com.chu.context.ApplicationContext;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class ContextClosedEvent extends ApplicationContextEvent {

	private static final long serialVersionUID = -3834547329394341319L;

	public ContextClosedEvent(ApplicationContext source) {
		super(source);
	}
}
