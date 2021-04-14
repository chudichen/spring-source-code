package com.chu.core.env;

import java.util.Map;

/**
 * @author chudichen
 * @date 2021-04-09
 */
public interface ConfigurableEnvironment {

	void setActiveProfile(String... profiles);

	void addActiveProfile(String profile);

	void setDefaultProfiles(String... profiles);

	MutablePropertySources getPropertySources();

	Map<String, Object> getSystemProperties();

	Map<String, Object> getSystemEnvironment();

	void merge(ConfigurableEnvironment parent);
}
