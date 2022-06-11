package com.rina.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 登陆异常
 * @author arvin
 * @date 2022/06/04
 */
@Slf4j
public class LoginException extends RuntimeException{

	private static final long serialVersionUID = 6054555843883656623L;

	public LoginException(String message) {
		super(message);
		log.info(message);
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
		log.info(message + "，原因：{}", cause.getMessage());
	}
}
