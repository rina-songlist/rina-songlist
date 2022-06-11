package com.rina.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.rina.exception.GuavaCacheDataNotExistException;
import com.rina.exception.GuavaCacheNullKeyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * guava cache的工具类
 * @author arvin
 * @date 2022/03/21
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class GuavaCacheUtil {

	private final CommonUtil commonUtil;

	private LoadingCache<String, String> cache = null;

	@PostConstruct
	public void init() {
		cache = CacheBuilder.newBuilder()
				.maximumSize(10)
				.expireAfterWrite(commonUtil.tokenExpireMillis(), TimeUnit.MILLISECONDS)
				.build(
						new CacheLoader<String, String>() {
							@Override
							public String load(String key) throws Exception {
								return null;
							}
						}
				);
	}

	/**
	 * 存入缓存
	 * @param key 键
	 * @param value 值
	 * @param <T> 值的数据类型
	 * @throws JsonProcessingException json序列化错误
	 * @throws GuavaCacheNullKeyException 键为空值
	 */
	public<T> void put(String key, T value) throws JsonProcessingException {
		if (StringUtils.isNotEmpty(key) && ObjectUtils.isNotEmpty(value)) {
			this.cache.put(key, CommonUtil.objectMapper().writeValueAsString(value));
			log.info("当前用户已存入cache");
			return;
		}
		if (StringUtils.isEmpty(key)) {
			log.error("缓存参数有误，key：{}，value：{}", key, value);
			throw new GuavaCacheNullKeyException();
		}

	}

	/**
	 * 获取缓存
	 * @param key 键
	 * @return 键所对应的值
	 * @param <T> 值的数据类型
	 * @throws JsonProcessingException json序列化错误
	 * @throws GuavaCacheDataNotExistException 值不存在
	 */
	public<T> T get(String key) throws JsonProcessingException {
		final String stringValue = this.cache.getIfPresent(key);

		if (stringValue == null) {
			throw new GuavaCacheDataNotExistException("当前数据不存在！");
		}
		return CommonUtil.objectMapper().readValue(stringValue, new TypeReference<T>() {
		});
	}

	/**
	 * 删除键
	 * @param key 键
	 * @throws GuavaCacheNullKeyException 键为空值
	 */
	public void delete(String key) {
		if (StringUtils.isEmpty(key)) {
			throw new GuavaCacheNullKeyException();
		}

		this.cache.invalidate(key);
	}

}
