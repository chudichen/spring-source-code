package com.chudichen.spring.aop;

/**
 * @author chudichen
 * @date 2021-02-04
 */
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
