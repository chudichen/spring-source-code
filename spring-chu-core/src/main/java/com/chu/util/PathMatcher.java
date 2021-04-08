package com.chu.util;

import java.util.Comparator;
import java.util.Map;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public interface PathMatcher {

	boolean isPattern(String path);

	boolean match(String pattern, String path);

	boolean matchStart(String pattern, String path);

	String extractPathWithinPattern(String pattern, String path);

	Map<String, String> extractUriTemplateVariables(String pattern, String path);

	Comparator<String> getPatternComparator(String path);

	String combine(String pattern1, String pattern2);
}
