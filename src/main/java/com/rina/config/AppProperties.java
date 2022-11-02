package com.rina.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义属性
 *
 * @author arvin
 * @date 2022/02/09
 */
@Configuration
@ConfigurationProperties(prefix = "rina")
public class AppProperties {

	@Getter
	@Setter
	private Jwt jwt = new Jwt();

	@Getter
	@Setter
	private AsyncPool asyncPool = new AsyncPool();

	@Getter
	@Setter
	// token相关设置
	public static class Jwt {
		// token所对应的header名
		private String header = "Authorization";
		// token过期时间
		private String tokenExpireTime = "60*1000";
		// token缓存工具(此处使用redis或guava)
		private String cacheType = "redis";
	}

	@Getter
	@Setter
	// Spring Async自定义线程池相关的设置
	public static class AsyncPool {
		// 核心线程数
		private Integer corePoolSize = 2;
		// 最大线程数
		private Integer maxPoolSize = 5;
		// 队列大小
		private Integer queueCapacity = 10;
		// 线程最大空闲时间
		private Integer keepAliveSeconds =  60;
	}

}
