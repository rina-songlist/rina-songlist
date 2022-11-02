package com.rina.exception;

/**
 * 数据库连接错误的异常
 * @author arvin
 * @date 2022/06/22
 */
public class JdbcConnectFailedException extends RuntimeException{

	private static final long serialVersionUID = -5066376423168595668L;

	public JdbcConnectFailedException(String message) {
		super(message);
	}

	public JdbcConnectFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public JdbcConnectFailedException(Throwable cause) {
		super(cause);
	}
}
