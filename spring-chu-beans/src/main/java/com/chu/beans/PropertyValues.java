package com.chu.beans;

import com.chu.lang.Nullable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author chudichen
 * @date 2021-03-30
 */
public interface PropertyValues extends Iterable<PropertyValue> {

	/**
	 * 返回一个迭代器
	 *
	 * @return 迭代器
	 */
	@Override
	default Iterator<PropertyValue> iterator() {
		return Arrays.asList(getPropertyValues()).iterator();
	}

	/**
	 * 切分
	 *
	 * @return 切
	 */
	@Override
	default Spliterator<PropertyValue> spliterator() {
		return Spliterators.spliterator(getPropertyValues(), 0);
	}

	/**
	 * 返回一个流
	 *
	 * @return stream
	 */
	default Stream<PropertyValue> stream() {
		return StreamSupport.stream(spliterator(), false);
	}

	/**
	 * 返回持有的属性对象
	 *
	 * @return 属性
	 */
	PropertyValue[] getPropertyValues();

	/**
	 * 返回一个属性值
	 *
	 * @param propertyName 属性名
	 * @return 属性
	 */
	@Nullable
	PropertyValue getPropertyValue(String propertyName);

	/**
	 * 返回前面的属性
	 *
	 * @param old 旧的属性值
	 * @return 属性
	 */
	PropertyValues changesSince(PropertyValues old);

	/**
	 * 是否包含目标元素
	 *
	 * @param propertyName 属性名
	 * @return {@code true}标示包含
	 */
	boolean contains(String propertyName);

	/**
	 * 是否为空
	 *
	 * @return {@code true}标示空
	 */
	boolean isEmpty();
}
