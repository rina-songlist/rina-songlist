package com.rina.resp;

import com.rina.enums.ResultCode;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回体的总父类
 *
 * @author arvin
 * @date 2022/02/07
 */
@Data
@Hidden
public class Resp implements Serializable {

	private static final long serialVersionUID = 167542788756270620L;

	/**
	 * 网络状态码
	 */
	private Integer code;

	/**
	 * 信息描述
	 */
	private String message;

	protected Resp() {};

	protected void setByResultCode(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}

	public static Resp succeed() {
		return succeed(ResultCode.OK);
	}

	public static Resp succeed(ResultCode resultCode) {
		final Resp resp = new Resp();
		resp.setByResultCode(resultCode);
		return resp;
	}

	public static Resp notFound() {
		return failed(ResultCode.NOT_FOUND);
	}

	public static Resp serverError() {
		return failed(ResultCode.INTERNAL_SERVER_ERROR);
	}

	public static Resp forbidden() {
		return failed(ResultCode.FORBIDDEN);
	}

	public static Resp unauthorized() {
		return failed(ResultCode.UNAUTHORIZED);
	}

	public static Resp failed(ResultCode resultCode) {
		final Resp resp = new Resp();
		resp.setByResultCode(resultCode);
		return resp;
	}
	
}
