package com.chu.context;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ApplicationEventPublisher {

	/**
	 * 发布事件
	 *
	 * @param event 事件
	 */
	void publishEvent(ApplicationEvent event);
}
