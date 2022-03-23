package com.rina.service;

/**
 * 总返回service（提供一些内部的工具方法）
 *
 * @author arvin
 * @date 2022/03/24
 */
public interface PublicService {

	/**
	 * 数据可用性检查
	 * @param data 待检查数据
	 * @param <T> 待检查数据类型
	 * @return 是否可用
	 */
	default <T> boolean dataUsableCheck(T data) {
		if (data instanceof String) {
			return !"".equals(data) && !"undifined".equals(data);
		}
		if (data instanceof Long) {
			return !data.equals(0L);
		}
		return false;
	}

}
