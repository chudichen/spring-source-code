package com.chudichen.spring.eventmode;

/**
 * @author chudichen
 * @date 2020-08-20
 */
public class DoubleClickEventListener implements EventListener {

	@Override
	public void processEvent(Event event) {
		if ("doubleClick".equals(event.getType())) {
			System.out.println("双击事件被触发");
		}
	}
}
