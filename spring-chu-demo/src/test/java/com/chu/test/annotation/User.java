package com.chu.test.annotation;

import com.chu.stereotype.Component;

/**
 * @author chudichen
 * @date 2021-04-07
 */
@Component
public class User {

	public void say() {
		System.out.println("hello");
	}
}
