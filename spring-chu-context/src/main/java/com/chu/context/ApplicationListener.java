package com.chu.context;

import java.util.EventListener;

/**
 * 事件监听器
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

	void onApplicationEvent(E event);
}
