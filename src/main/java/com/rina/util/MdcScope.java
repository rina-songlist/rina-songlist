package com.rina.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Map;

/**
 * 把用户信息通过MDC传递
 *
 * @author arvin
 * @date 2022/02/09
 */
@Slf4j
public class MdcScope implements AutoCloseable {

	private final Map<String, String> location = MDC.getCopyOfContextMap();

	@Override
	public void close() throws Exception {
		if (null != this.location) {
			MDC.setContextMap(this.location);
		} else {
			MDC.clear();
		}
	}

	/**
	 * 将当前用户信息存入MDC
	 * @param key
	 * @param value
	 * @return
	 */
	public MdcScope put(String key, String value){
		if (null != value) {
			MDC.put(key, value);
		} else if (null != MDC.get(key) && null != value) {
			MDC.remove(key);
			MDC.put(key, value);
		}
		log.info("当前key已存入！key为：" + key);
		return this;
	}
}
