package com.chu.beans.factory;

/**
 * @author chudichen
 * @date 2021-04-02
 */
public interface DisposableBean {

	/**
	 * 销毁
	 *
	 * @throws Exception 异常
	 */
	void destroy() throws Exception;
}
