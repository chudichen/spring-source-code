package com.chu.core.io;


import java.io.IOException;
import java.io.InputStream;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public abstract class AbstractResource implements Resource {

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public boolean isReadable() {
		return false;
	}

	@Override
	public Resource createRelative(String relativePath) throws IOException {
		return null;
	}
}
