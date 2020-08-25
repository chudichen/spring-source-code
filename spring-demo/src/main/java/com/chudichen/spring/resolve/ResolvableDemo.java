package com.chudichen.spring.resolve;

import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * 解决
 *
 * @author chudichen
 * @date 2020-08-21
 */
public class ResolvableDemo {

	private HashMap<String, List<Integer>> customizedMap;

	public static void main(String[] args) throws Exception {
		ResolvableType customizedMap = ResolvableType.forField(ResolvableDemo.class.getDeclaredField("customizedMap"));
		System.out.println(customizedMap);
	}
}
