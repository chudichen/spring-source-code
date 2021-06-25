package com.chu.beans;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chudichen
 * @date 2021-04-16
 */
class MutablePropertyValuesTest {

	private MutablePropertyValues mutablePropertyValues;

	@BeforeEach
	public void init() {
		mutablePropertyValues = new MutablePropertyValues();
		mutablePropertyValues.addPropertyValue(new PropertyValue("name", "Tom"));
	}

    @Test
    void addPropertyValues() {
		Map<String, Integer> age = Maps.newHashMap("age", 18);
		mutablePropertyValues.addPropertyValues(age);
		PropertyValue[] propertyValues = mutablePropertyValues.getPropertyValues();
		assertThat(propertyValues.length > 0);
	}

    @Test
    void addPropertyValue() {
		mutablePropertyValues.addPropertyValue(new PropertyValue("age", "18"));
		assertThat(mutablePropertyValues.get("age").equals("18"));
    }

    @Test
    void testAddPropertyValue() {
    }

    @Test
    void add() {
    }

    @Test
    void setPropertyValueAt() {
    }

    @Test
    void removePropertyValue() {
    }

    @Test
    void testRemovePropertyValue() {
    }

    @Test
    void iterator() {
    }

    @Test
    void spliterator() {
    }

    @Test
    void getPropertyValues() {
    }

    @Test
    void getPropertyValue() {
    }

    @Test
    void get() {
    }

    @Test
    void changesSince() {
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
    }
}