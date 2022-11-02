package com.rina.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Async自定义线程池的配置类
 * @author arvin
 * @date 2022/09/30
 */
@Configuration
@EnableAsync
@AllArgsConstructor
public class AsyncPoolConfig implements AsyncConfigurer {

	private AppProperties appProperties;

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(appProperties.getAsyncPool().getCorePoolSize());
		executor.setMaxPoolSize(appProperties.getAsyncPool().getMaxPoolSize());
		executor.setQueueCapacity(appProperties.getAsyncPool().getQueueCapacity());
		executor.setKeepAliveSeconds(appProperties.getAsyncPool().getKeepAliveSeconds());
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

		// 等所有任务完成后再关闭此线程池
		executor.setWaitForTasksToCompleteOnShutdown(true);
		// 未完成任务等待时间
		executor.setAwaitTerminationSeconds(60);

		executor.initialize();
		return executor;
	}
}
