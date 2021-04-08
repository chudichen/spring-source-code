package com.chu.beans;

import java.io.Serializable;

/**
 * 未找到bean的时候报错
 *
 * @author chudichen
 * @date 2021-04-01
 */
public class BeansException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -4244719387670669284L;

	public BeansException(String msg) {
		super(msg);
	}

	public BeansException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
