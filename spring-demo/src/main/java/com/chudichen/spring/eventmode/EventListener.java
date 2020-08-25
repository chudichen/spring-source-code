package com.chudichen.spring.eventmode;

/**
 * @author chudichen
 * @date 2020-08-20
 */
public interface EventListener {

	void processEvent(Event event);
}
