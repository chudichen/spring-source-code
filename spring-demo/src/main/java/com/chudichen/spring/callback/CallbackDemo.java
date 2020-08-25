package com.chudichen.spring.callback;

/**
 * @author chudichen
 * @date 2020-08-20
 */
public class CallbackDemo {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			System.out.println("我要休息了");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我被回调了");
		});
		thread.start();
	}
}
