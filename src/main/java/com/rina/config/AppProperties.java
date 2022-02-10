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
	public static class Jwt {
		private String header = "Authorization";
		// token过期时间
		private Long tokenExpireTime = 60_000L;
	}

}
