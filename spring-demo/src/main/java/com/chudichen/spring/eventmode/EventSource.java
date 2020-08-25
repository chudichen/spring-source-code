package com.chudichen.spring.eventmode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chudichen
 * @date 2020-08-20
 */
public class EventSource {

	private List<EventListener> listeners = new ArrayList<>();

	public void register(EventListener listener) {
		listeners.add(listener);
	}

	public void publishEvent(Event event) {
		listeners.forEach(listener -> listener.processEvent(event));
	}

}
