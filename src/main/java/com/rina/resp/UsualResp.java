package com.rina.resp;

import com.rina.enums.ResultCode;
import lombok.*;

import java.io.Serializable;

/**
 * 含数据的普通成功返回体
 *
 * @author arvin
 * @date 2022/02/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UsualResp<T> extends Resp implements Serializable {

	private static final long serialVersionUID = -1794320300202764932L;

	/**
	 * 返回信息
	 */
	private T data;

	public static <T> UsualResp<T> succeed(ResultCode resultCode, T data) {
		final UsualResp<T> resp = new UsualResp<>();
		resp.setByResultCode(resultCode);
		resp.setData(data);
		return resp;
	}

	public static <T> UsualResp<T> succeed(T data) {
		final UsualResp<T> resp = new UsualResp<>();
		resp.setByResultCode(ResultCode.OK);
		resp.setData(data);
		return resp;
	}
}
