package com.chu.context.event;

import com.chu.context.ApplicationContext;
import com.chu.context.ApplicationEvent;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3758579772757268092L;

	public ApplicationContextEvent(ApplicationContext source) {
		super(source);
	}

	public final ApplicationContext getApplicationContext() {
		return (ApplicationContext) getSource();
	}
}
