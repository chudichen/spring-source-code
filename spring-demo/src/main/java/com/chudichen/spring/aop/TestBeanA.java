package com.chudichen.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chudichen
 * @date 2021-02-04
 */
@Component
public class TestBeanA implements GetStr {

//	@Autowired
//	private TestBeanB testBean;

	private String testStr = "testStrA";

	@Override
	public String getTestStr() {
//		System.out.println(testBean.toString());
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
