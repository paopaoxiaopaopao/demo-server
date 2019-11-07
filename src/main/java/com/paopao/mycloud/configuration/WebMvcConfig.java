package com.paopao.mycloud.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMVC配置类 访问http://ip:port/web/management/ 或http://ip:port/web/management 时直接
 * 指向/management/index.html
 * 
 * @author pp
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/app/").setViewName("forward:/app/index.html");
		registry.addViewController("/app").setViewName("forward:/app/index.html");
		registry.addViewController("/management/").setViewName("forward:/management/index.html");
		registry.addViewController("/management").setViewName("forward:/management/index.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

}