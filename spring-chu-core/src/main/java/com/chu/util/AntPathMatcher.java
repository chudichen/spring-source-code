package com.chu.util;

import java.util.Comparator;
import java.util.Map;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public class AntPathMatcher implements PathMatcher {

	@Override
	public boolean isPattern(String path) {
		return false;
	}

	@Override
	public boolean match(String pattern, String path) {
		return false;
	}

	@Override
	public boolean matchStart(String pattern, String path) {
		return false;
	}

	@Override
	public String extractPathWithinPattern(String pattern, String path) {
		return null;
	}

	@Override
	public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
		return null;
	}

	@Override
	public Comparator<String> getPatternComparator(String path) {
		return null;
	}

	@Override
	public String combine(String pattern1, String pattern2) {
		return null;
	}
}
