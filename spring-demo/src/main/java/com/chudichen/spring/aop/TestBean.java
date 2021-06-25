package com.chudichen.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author chudichen
 * @date 2021-02-04
 */
@Component
public class TestBean {

	private String testStr = "testStr";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	@Override
	public String toString() {
		return "TestBean{" +
				"testStr='" + testStr + '\'' +
				'}';
	}
}
