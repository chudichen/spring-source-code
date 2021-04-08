package com.chu.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chudichen
 * @date 2021-03-30
 */
public class PropertyValues {

	private final Map<String, PropertyValue> propertyMap = new HashMap<>(256);

	public void addPropertyValue(PropertyValue pv) {
		propertyMap.put(pv.getName(), pv);
	}

	public PropertyValue[] getPropertyValues() {
		return this.propertyMap.values().toArray(new PropertyValue[0]);
	}

	public PropertyValue getPropertyValue(String propertyName) {
		return propertyMap.get(propertyName);
	}
}
