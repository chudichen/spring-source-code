package com.chu.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chudichen
 * @date 2021-03-31
 */
public interface InputStreamSource {

	/**
	 * 获取内容的输入流
	 *
	 * @return
	 * @throws IOException
	 */
	InputStream getInputStream() throws IOException;
}
