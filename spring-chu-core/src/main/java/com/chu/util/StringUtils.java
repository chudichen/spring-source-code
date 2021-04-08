package com.chu.util;

import com.chu.lang.Nullable;

import java.util.*;

/**
 * @author chudichen
 * @date 2021-04-01
 */
public abstract class StringUtils {

	private static final String[] EMPTY_STRING_ARRAY = {};

	private static final String FOLDER_SEPARATOR = "/";

	private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

	private static final String TOP_PATH = "..";

	private static final String CURRENT_PATH = ".";

	private static final char EXTENSION_SEPARATOR = '.';


	public static String applyRelativePath(String path, String relativePath) {
		int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
		if (separatorIndex != -1) {
			String newPath = path.substring(0, separatorIndex);
			if (!relativePath.startsWith(FOLDER_SEPARATOR)) {
				newPath += FOLDER_SEPARATOR;
			}
			return newPath + relativePath;
		} else {
			return relativePath;
		}
	}

	public static String cleanPath(String path) {
		if (!hasLength(path)) {
			return path;
		}
		String pathToUse = replace(path, WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR);

		if (pathToUse.indexOf('.') == -1) {
			return pathToUse;
		}

		int prefixIndex = pathToUse.indexOf(':');
		String prefix = "";
		if (prefixIndex != -1) {
			prefix = pathToUse.substring(0, prefixIndex + 1);
			if (prefix.contains(FOLDER_SEPARATOR)) {
				prefix = "";
			} else {
				pathToUse = pathToUse.substring(prefixIndex + 1);
			}
		}
		if (pathToUse.startsWith(FOLDER_SEPARATOR)) {
			prefix = prefix + FOLDER_SEPARATOR;
			pathToUse = pathToUse.substring(1);
		}

		String[] pathArray = delimitedListToStringArray(pathToUse, FOLDER_SEPARATOR);
		LinkedList<String> pathElements = new LinkedList<>();
		int tops = 0;

		for (int i = 0; i < pathArray.length; i++) {
			String element = pathArray[i];
			if (CURRENT_PATH.equals(element)) {

			} else if (TOP_PATH.equals(element)) {
				tops++;
			} else {
				if (tops > 0) {
					tops--;
				} else {
					pathElements.addFirst(element);
				}
			}
		}

		if (pathArray.length == pathElements.size()) {
			return prefix + pathToUse;
		}

		for (int i = 0; i < tops; i++) {
			pathElements.addFirst(TOP_PATH);
		}

		if (pathElements.size() == 1 && "".equals(pathElements.getLast()) && !prefix.endsWith(FOLDER_SEPARATOR)) {
			pathElements.add(0, CURRENT_PATH);
		}

		return prefix + collectionToDelimitedString(pathElements, FOLDER_SEPARATOR);
	}

	public static String collectionToDelimitedString(@Nullable Collection<?> coll, String delim) {
		return collectionToDelimitedString(coll, delim, "", "");
	}

	public static String collectionToDelimitedString(
			@Nullable Collection<?> coll, String delim, String prefix, String suffix) {

		if (CollectionUtils.isEmpty(coll)) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		Iterator<?> it = coll.iterator();
		while (it.hasNext()) {
			sb.append(prefix).append(it.next()).append(suffix);
			if (it.hasNext()) {
				sb.append(delim);
			}
		}
		return sb.toString();
	}

	public static boolean hasLength(@Nullable String str) {
		return (str != null && !str.isEmpty());
	}

	public static String[] delimitedListToStringArray(@Nullable String str, @Nullable String delimiter) {
		return delimitedListToStringArray(str, delimiter, null);
	}

	public static String[] delimitedListToStringArray(
			@Nullable String str, @Nullable String delimiter, @Nullable String charsToDelete) {
		if (str == null) {
			return EMPTY_STRING_ARRAY;
		}
		if (delimiter == null) {
			return new String[]{str};
		}

		List<String> result = new ArrayList<>();
		if (delimiter.isEmpty()) {
			for (int i = 0; i < str.length(); i++) {
				result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
			}
		} else {
			int pos = 0;
			int delPos;
			while ((delPos = str.indexOf(delimiter, pos)) != -1) {
				result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
				pos = delPos + delimiter.length();
			}
			if (str.length() > 0 && pos <= str.length()) {
				result.add(deleteAny(str.substring(pos), charsToDelete));
			}
		}
		return toStringArray(result);
	}

	public static String deleteAny(String inString, @Nullable String charsToDelete) {
		if (!hasLength(inString) || !hasLength(charsToDelete)) {
			return inString;
		}

		int lastCharIndex = 0;
		char[] result = new char[inString.length()];
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (charsToDelete.indexOf(c) == -1) {
				result[lastCharIndex++] = c;
			}
		}
		if (lastCharIndex == inString.length()) {
			return inString;
		}
		return new String(result, 0, lastCharIndex);
	}

	public static String[] toStringArray(@Nullable Collection<String> collection) {
		return CollectionUtils.isEmpty(collection) ? EMPTY_STRING_ARRAY : collection.toArray(EMPTY_STRING_ARRAY);
	}

	public static String replace(String inString, String oldPattern, @Nullable String newPattern) {
		if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
			return inString;
		}
		int index = inString.indexOf(oldPattern);
		if (index == -1) {
			return inString;
		}

		int capacity = inString.length();
		if (newPattern.length() > oldPattern.length()) {
			capacity += 16;
		}
		StringBuilder sb = new StringBuilder(capacity);

		int pos = 0;
		int patLen = oldPattern.length();
		while (index >= 0) {
			sb.append(inString, pos, index);
			sb.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}

		sb.append(inString, pos, inString.length());
		return sb.toString();
	}

	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
}
