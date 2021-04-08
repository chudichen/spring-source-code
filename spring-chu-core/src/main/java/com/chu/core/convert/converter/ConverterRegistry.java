package com.chu.core.convert.converter;

/**
 * 类型转换器注册接口
 *
 * @author chudichen
 * @date 2021-04-01
 */
public interface ConverterRegistry {

	void addConverter(Converter<?, ?> converter);

	void addConverterFactory(ConverterFactory<?, ?> converterFactory);

	void addConverter(GenericConverter converter);
}
