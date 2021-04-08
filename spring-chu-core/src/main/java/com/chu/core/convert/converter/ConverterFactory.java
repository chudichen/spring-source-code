package com.chu.core.convert.converter;

/**
 * 类型转换工厂
 *
 * @author chudichen
 * @date 2021-04-01
 */
@FunctionalInterface
public interface ConverterFactory<S, R> {

	<T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
