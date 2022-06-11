package com.rina.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 要缓存的guava的键为空的异常
 * @author arvin
 * @date 2022/06/06
 */
@Slf4j
public class GuavaCacheNullKeyException extends RuntimeException{

	private static final long serialVersionUID = -4128594164662237107L;

	public GuavaCacheNullKeyException() {
		super();
		log.error("key值为空！");
	}

	public GuavaCacheNullKeyException(String message) {
		super(message);
	}

	public GuavaCacheNullKeyException(String message, Throwable cause) {
		super(message, cause);
	}
}
