package com.rina.util;

import com.rina.domain.vo.UserDetailsVo;

/**
 * 自定义线程数据读写工具
 *
 * @author arvin
 * @date 2022/03/21
 */
public class MyThreadLocal {

	private static final ThreadLocal<UserDetailsVo> USER_THREAD_LOCAL = new ThreadLocal<>();

	public static void set(UserDetailsVo userDetails) {
		USER_THREAD_LOCAL.set(userDetails);
	}

	public static void unset() {
		USER_THREAD_LOCAL.remove();
	}

	public static UserDetailsVo get() {
		return USER_THREAD_LOCAL.get();
	}

}
