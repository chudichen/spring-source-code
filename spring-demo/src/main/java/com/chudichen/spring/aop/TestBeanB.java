package com.chudichen.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author chudichen
 * @date 2021-02-04
 */
@Component
public class TestBeanB implements GetStr {

//	@Autowired
//	private TestBeanA testBean;

	private String testStr = "testStrB";

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
