package com.rina.enums;

/**
 * 返回体集合
 *
 * @author arvin
 * @date 2022/02/07
 */
public enum ResultCode {

	/* 成功的返回体 */
	OK(200,"请求成功"),
	CREATED(201,"创建成功"),
	DELETED(204,"删除成功"),

	/* 失败的返回体 */
	BAD_REQUEST(400,"请求的地址不存在或者包含不支持的参数"),
	UNAUTHORIZED(401,"未授权"),
	FORBIDDEN(403,"被禁止访问"),
	NOT_FOUND(404,"请求的资源不存在"),
	INTERNAL_SERVER_ERROR(500,"服务器内部错误");

	/**
	 * 网页状态码
	 */
	private Integer code;

	/**
	 * 信息描述
	 */
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	ResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
