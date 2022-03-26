package com.rina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域相关的配置类
 *
 * @author arvin
 * @date 2022/02/16
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedHeaders("*")
				.allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS", "HEAD")
				.allowedOriginPatterns("*")
				.exposedHeaders("*")
				.allowCredentials(true).maxAge(3600);
	}

}
