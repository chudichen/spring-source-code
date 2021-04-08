package com.chu.context.event;

import com.chu.context.ApplicationContext;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

	private static final long serialVersionUID = 6223286042998340926L;

	public ContextRefreshedEvent(ApplicationContext source) {
		super(source);
	}
}
