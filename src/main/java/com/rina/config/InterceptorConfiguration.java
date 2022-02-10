package com.rina.config;

import com.rina.interceptor.AuthInfoInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义拦截器的配置文件
 *
 * @author arvin
 * @date 2022/02/09
 */
@Configuration
@RequiredArgsConstructor
public class InterceptorConfiguration implements WebMvcConfigurer {

	private final AuthInfoInterceptor authInfoInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		final List<String> excludePaths = Arrays.asList("/backend/login", "/swagger-ui.html**");

		registry.addInterceptor(authInfoInterceptor)
				.excludePathPatterns(excludePaths);
	}
}
