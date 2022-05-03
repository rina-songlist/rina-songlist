package com.rina.util;

import java.util.Map;

/**
 * 自定义线程数据读写工具
 *
 * @author arvin
 * @date 2022/03/21
 */
public class MyThreadLocal {

	private static final ThreadLocal<Map<String, String>> USER_THREAD_LOCAL = new ThreadLocal<>();

	public static void set(Map<String, String> userDetails) {
		USER_THREAD_LOCAL.set(userDetails);
	}

	public static void unset() {
		USER_THREAD_LOCAL.remove();
	}

	public static Map<String, String> get() {
		return USER_THREAD_LOCAL.get();
	}

}
