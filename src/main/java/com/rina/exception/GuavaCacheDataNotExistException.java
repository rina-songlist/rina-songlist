package com.rina.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * guava缓存中此键的值为空的异常
 * @author arvin
 * @date 2022/06/06
 */
@Slf4j
public class GuavaCacheDataNotExistException extends RuntimeException{

	private static final long serialVersionUID = 2098029593892858189L;

	public GuavaCacheDataNotExistException(String message) {
		super(message);
		log.info(message);
	}

	public GuavaCacheDataNotExistException(String message, Throwable cause) {
		super(message, cause);
		log.info(message + "，原因：{}", cause.getMessage());
	}
}
