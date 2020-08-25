package com.chudichen.spring.eventmode;

/**
 * @author chudichen
 * @date 2020-08-20
 */
public class EventModeDemo {

	public static void main(String[] args) {
		EventSource eventSource = new EventSource();
		SingleClickEventListener singleClickEventListener = new SingleClickEventListener();
		DoubleClickEventListener doubleClickEventListener = new DoubleClickEventListener();
		eventSource.register(singleClickEventListener);
		eventSource.register(doubleClickEventListener);
		Event event = new Event();
		event.setType("singleClick");
		eventSource.publishEvent(event);
	}
}
