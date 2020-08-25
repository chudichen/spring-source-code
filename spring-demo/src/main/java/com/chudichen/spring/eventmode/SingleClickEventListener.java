package com.chudichen.spring.eventmode;

/**
 * @author chudichen
 * @date 2020-08-20
 */
public class SingleClickEventListener implements EventListener {

	@Override
	public void processEvent(Event event) {
		if ("singleClick".equals(event.getType())) {
			System.out.println("单击事件被触发");
		}
	}
}
