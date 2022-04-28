package com.rina.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.rina.config.AppProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 把用户信息通过Guava Cache缓存
 *
 * @author arvin
 * @date 2022/03/21
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class GuavaCacheUtil {

	private final AppProperties appProperties;

	private LoadingCache<String, Map<String, String>> cache = null;

	@PostConstruct
	public void init() {
		long expireTime = 1L;
		final String[] strings = appProperties.getJwt().getTokenExpireTime().split("\\*");
		for (String string : strings) {
			expireTime *= Long.parseLong(string);
		}

		cache = CacheBuilder.newBuilder()
				.maximumSize(10)
				.expireAfterWrite(expireTime, TimeUnit.MILLISECONDS)
				.build(
						new CacheLoader<String, Map<String, String>>() {
							@Override
							public HashMap<String, String> load(String key) throws Exception {
								return null;
							}
						}
				);
	}

	public void put(String token, Map<String, String> userDetails) {
		Optional.ofNullable(get(token))
				.orElseGet(() -> {
					this.cache.put(token, userDetails);
					return null;
				});
		log.info("当前用户已存入cache");
	}

	public Map<String, String> get(String token) {
		return this.cache.getIfPresent(token);
	}

}
