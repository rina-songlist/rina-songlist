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
				.allowedMethods("POST", "GET", "DELETE", "PUT")
				.allowedOriginPatterns("*")
				.exposedHeaders("*")
				.allowCredentials(true).maxAge(3600);
	}

//	@Bean
//	public FilterRegistrationBean corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfig());
//		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//		//*****这里设置了优先级*****
//		bean.setOrder(1);
//		return bean;
//	}
//
//	private CorsConfiguration corsConfig() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		// 请求常用的三种配置，*代表允许所有，也可以自定义属性（比如 header 只能带什么，只能是 post 方式等）
//		corsConfiguration.addAllowedOrigin("*");
//		corsConfiguration.addAllowedOriginPattern("*");
//		corsConfiguration.addAllowedHeader("*");
//		corsConfiguration.addAllowedMethod("*");
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setMaxAge(3600L);
//		return corsConfiguration;
//	}
}
