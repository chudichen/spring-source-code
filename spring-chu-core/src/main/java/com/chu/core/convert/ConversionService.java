package com.chu.core.convert;

/**
 * 类型转换抽象接口
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface ConversionService {

	boolean canConvert(Class<?> sourceType, Class<?> targetType);

	<T> T convert(Object source, Class<T> targetType);
}
