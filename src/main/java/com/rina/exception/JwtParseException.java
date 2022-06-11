package com.rina.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Jwt解析异常（一般特指过期或非法）
 * @author arvin
 * @date 2022/06/04
 */
@Slf4j
public class JwtParseException extends RuntimeException{

	private static final long serialVersionUID = -1534129311730667158L;

	public JwtParseException(String message) {
		super(message);
		log.info(message);
	}

	public JwtParseException(String message, Throwable cause) {
		super(message, cause);
		log.info(message + "，原因：{}", cause.getMessage());
	}
}
