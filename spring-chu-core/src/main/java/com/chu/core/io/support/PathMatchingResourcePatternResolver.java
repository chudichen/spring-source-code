package com.chu.core.io.support;

import com.chu.core.io.DefaultResourceLoader;
import com.chu.core.io.Resource;
import com.chu.core.io.ResourceLoader;
import com.chu.util.AntPathMatcher;
import com.chu.util.PathMatcher;

import java.io.IOException;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class PathMatchingResourcePatternResolver implements ResourcePatternResolver {

	private final ResourceLoader resourceLoader;
	private PathMatcher pathMatcher = new AntPathMatcher();

	public PathMatchingResourcePatternResolver() {
		this.resourceLoader = new DefaultResourceLoader();
	}

	@Override
	public Resource[] getResources(String locationPattern) throws IOException {
		return new Resource[0];
	}

	@Override
	public Resource getResource(String location) {
		return null;
	}

	@Override
	public ClassLoader getClassLoader() {
		return null;
	}
}
