package com.chu.core.io.support;

import com.chu.core.io.Resource;
import com.chu.core.io.ResourceLoader;

import java.io.IOException;


/**
 * @author chudichen
 * @date 2021-03-31
 */
public interface ResourcePatternResolver extends ResourceLoader {

	String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

	Resource[] getResources(String locationPattern) throws IOException;
}
