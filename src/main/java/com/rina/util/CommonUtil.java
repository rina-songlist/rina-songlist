package com.rina.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.rina.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 共同基础工具类
 * @author arvin
 * @date 2022/06/06
 */
@Component
@RequiredArgsConstructor
public class CommonUtil {

	private final AppProperties appProperties;

	/**
	 * token过期时间（毫秒）
	 * @return
	 */
	public long tokenExpireMillis() {
		long expireTime = 1L;
		final String[] strings = appProperties.getJwt().getTokenExpireTime().split("\\*");
		for (String string : strings) {
			expireTime *= Long.parseLong(string);
		}
		return expireTime;
	}

	/**
	 * token过期时间（秒）
	 * @return
	 */
	public long tokenExpireSeconds() {
		long millis = tokenExpireMillis();
		return millis /= 1000;
	}

	/**
	 * 自定义Jackson序列器（主要为token缓存服务）
	 * @return
	 */
	public static ObjectMapper objectMapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
				ObjectMapper.DefaultTyping.NON_FINAL,
				JsonTypeInfo.As.WRAPPER_ARRAY);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return objectMapper;
	}

}
