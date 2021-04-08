package com.chu.beans.factory.config;

import com.chu.beans.factory.HierarchicalBeanFactory;
import com.chu.core.convert.ConversionService;
import com.chu.util.StringValueResolver;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

	/**
	 * 添加bean的后置处理器
	 *
	 * @param beanPostProcessor 后置处理器
	 */
	void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

	/**
	 * 销毁bean
	 */
	void destroySingletons();

	void addEmbeddedValueResolver(StringValueResolver valueResolver);

	String resolveEmbeddedValue(String value);

	void setConversionService(ConversionService conversionService);

	ConversionService getConversionService();
}
