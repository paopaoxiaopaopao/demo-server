package com.paopao.mycloud.configuration;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author pp
 *
 */
@Configuration
@ComponentScan("com.paopao.mycloud.service.impl")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		// taskExecutor.setCorePoolSize(5);// 线程池维护线程的最少数量
		taskExecutor.setMaxPoolSize(10);// 线程池维护线程的最大数量
		// taskExecutor.setQueueCapacity(25);// 缓冲队列的数量
		// taskExecutor.setKeepAliveSeconds(60);
		taskExecutor.setThreadNamePrefix("mycloud-");
		taskExecutor.initialize();// 初始化
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
}
