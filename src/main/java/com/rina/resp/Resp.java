package com.rina.resp;

import com.rina.enums.ResultCode;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;

/**
 * 返回体的总父类
 *
 * @author arvin
 * @date 2022/02/07
 */
@Data
@ApiIgnore
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
		final Resp resp = new Resp();
		resp.setByResultCode(ResultCode.OK);
		return resp;
	}

	public static Resp succeed(ResultCode resultCode) {
		final Resp resp = new Resp();
		resp.setByResultCode(resultCode);
		return resp;
	}

	public static Resp failed() {
		final Resp resp = new Resp();
		resp.setByResultCode(ResultCode.NOT_FOUND);
		return resp;
	}

	public static Resp failed(ResultCode resultCode) {
		final Resp resp = new Resp();
		resp.setByResultCode(resultCode);
		return resp;
	}
	
}
