package com.rina.resp;

import com.rina.enums.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 表单页面返回体
 *
 * @author arvin
 * @date 2022/02/08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResp<T> extends Resp implements Serializable {

	private static final long serialVersionUID = -3792430422200977676L;

	/**
	 * 返回信息
	 */
	private T data;

	/**
	 * 表单总页数
	 */
	private Integer totalPages;

	public static<T> PageResp<T> succeed(ResultCode resultCode, T data) {
		final PageResp<T> resp = new PageResp<>();
		resp.setByResultCode(resultCode);
		resp.setData(data);
		return resp;
	}

	public static<T> PageResp<T> succeed(ResultCode resultCode,
	                                     T data,
	                                     int totalPages) {
		final PageResp<T> resp = new PageResp<>();
		resp.setByResultCode(resultCode);
		resp.setData(data);
		resp.setTotalPages(totalPages);
		return resp;
	}

}
