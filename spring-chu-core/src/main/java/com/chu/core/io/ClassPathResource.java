package com.chu.core.io;

import com.chu.lang.Nullable;
import com.chu.util.Assert;
import com.chu.util.ClassUtils;
import com.chu.util.StringUtils;

import java.io.IOException;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public class ClassPathResource extends AbstractFileResolvingResource {

	private final String path;

	@Nullable
	private ClassLoader classLoader;

	@Nullable
	private Class<?> clazz;

	public ClassPathResource(String path) {
		this.path = path;
	}

	public ClassPathResource(String path, @Nullable Class<?> clazz) {
		Assert.notNull(path, "Path must not be null");
		this.path = StringUtils.cleanPath(path);
		this.clazz = clazz;
	}

	public ClassPathResource(String path, @Nullable ClassLoader classLoader) {
		Assert.notNull(path, "Path must not be null");
		String pathToUse = StringUtils.cleanPath(path);
		if (pathToUse.startsWith("/")) {
			path = pathToUse.substring(1);
		}
		this.path = pathToUse;
		this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
	}

	@Override
	public Resource createRelative(String relativePath) throws IOException {
		String pathToUse = StringUtils.applyRelativePath(this.path, relativePath);
		return this.clazz != null ? new ClassPathResource(pathToUse, this.clazz) :
				new ClassPathResource(pathToUse, this.classLoader);
	}

	public final String getPath() {
		return this.path;
	}
}
