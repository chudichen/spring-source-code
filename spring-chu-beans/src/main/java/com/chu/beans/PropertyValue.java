package com.chu.beans;

/**
 * bean属性信息
 *
 * @author chudichen
 * @date 2021-03-30
 */
public class PropertyValue {

	private final String name;

	private final Object value;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
}
