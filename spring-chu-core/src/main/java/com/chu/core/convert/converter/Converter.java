package com.chu.core.convert.converter;

/**
 * 类型转换抽象接口
 *
 * @author chudichen
 * @date 2021-04-01
 */
@FunctionalInterface
public interface Converter<S, T> {

	/**
	 * 类型转换
	 *
	 * @param source 源
	 * @return 目标
	 */
	T convert(S source);
}
