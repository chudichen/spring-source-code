package com.chu.web.servlet;

import com.chu.beans.PropertyValues;
import com.chu.core.env.ConfigurableEnvironment;

import javax.annotation.Nullable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chudichen
 * @date 2021-04-15
 */
public abstract class HttpServletBean extends HttpServlet {

	@Nullable
	private ConfigurableEnvironment environment;

	private final Set<String> requiredProperties = new HashSet<>(4);

	protected final void addRequiredProperty(String property) {
		this.requiredProperties.add(property);
	}

	@Override
	public void init() throws ServletException {
		PropertyValues pvs = new ServletConfigPropertyValues();
	}

	private static class ServletConfigPropertyValues
}
