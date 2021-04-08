package com.chu.util;

import com.chu.lang.Nullable;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public abstract class ClassUtils {

	/** 包的分割符 */
	private static final char PACKAGE_SEPARATOR = '.';

	/** 路径的分隔符 */
	private static final char PATH_SEPARATOR = '/';

	private static final char INNER_CLASS_SEPARATOR = '$';

	public static final String CLASS_FILE_SUFFIX = ".class";

	public static final String CGLIB_CLASS_SEPARATOR = "$$";

	public static String convertClassNameToResourcePath(String className) {
		Assert.notNull(className, "Class name must not be null");
		return className.replace(PACKAGE_SEPARATOR, PATH_SEPARATOR);
	}

	@Nullable
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) {
			// 不处理
		}
		if (cl == null) {
			// 无法通过线程获取到类加载器，则使用此类的类加载器
			cl = ClassLoader.class.getClassLoader();
			if (cl == null) {
				try {
					cl = ClassLoader.getSystemClassLoader();
				} catch (Throwable ex) {
					// 不处理
				}
			}
		}
		return cl;
	}

	public static String getShortName(String className) {
		Assert.hasLength(className, "Class name must not be empty");
		int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		int nameEndIndex = className.indexOf(CGLIB_CLASS_SEPARATOR);
		if (nameEndIndex == -1) {
			nameEndIndex = className.length();
		}
		String shortName = className.substring(lastDotIndex + 1, nameEndIndex);
		shortName = shortName.replace(INNER_CLASS_SEPARATOR, PACKAGE_SEPARATOR);
		return shortName;
	}
}
