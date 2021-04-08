package com.chu.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.chu.beans.factory.config.BeanDefinition;
import com.chu.core.io.support.ResourcePatternResolver;
import com.chu.core.type.filter.TypeFilter;
import com.chu.lang.Nullable;
import com.chu.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 类路径扫描器
 *
 * @author chudichen
 * @date 2021-03-30
 */
public class ClassPathScanningCandidateComponentProvider {

	static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

	private String resourcePattern = DEFAULT_RESOURCE_PATTERN;

	private final List<TypeFilter> includeFilters = new LinkedList<>();

	private final List<TypeFilter> excludeFilters = new LinkedList<>();

	@Nullable
	private ResourcePatternResolver resourcePatternResolver;


	/**
	 * 通过包扫描加载class
	 *
	 * @param basePackages 基本路径
	 * @return 加载后的BeanDefinition
	 */
	public Set<BeanDefinition> scanCandidateComponents(String[] basePackages) {
		Set<Class<?>> classes = Arrays.stream(basePackages).flatMap(basePackage -> ClassUtil.scanPackageByAnnotation(basePackage, Component.class).stream()).collect(Collectors.toSet());
		return classes.stream().map(BeanDefinition::new).collect(Collectors.toSet());
	}

}
