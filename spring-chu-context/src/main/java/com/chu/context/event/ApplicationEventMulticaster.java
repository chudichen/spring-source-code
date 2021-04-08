package com.chu.context.event;

import com.chu.context.ApplicationEvent;
import com.chu.context.ApplicationListener;

/**
 * 容器事件广播器
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(ApplicationListener<?> listener);

	void removeApplicationListener(ApplicationListener<?> listener);

	void multicastEvent(ApplicationEvent event);
}
