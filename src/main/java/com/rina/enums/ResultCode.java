package com.rina.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回体集合
 *
 * @author arvin
 * @date 2022/02/07
 */
@Getter
@AllArgsConstructor
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
	private final Integer code;

	/**
	 * 信息描述
	 */
	private final String message;

}
