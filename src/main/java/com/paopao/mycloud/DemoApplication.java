package com.paopao.mycloud;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.paopao.mycloud.dao")
@EnableFeignClients
public class DemoApplication {

	// @Value("${casServerUrlPrefix}")
	// private String casServerUrlPrefix;
	//
	// @Value("${casServerLoginUrl}")
	// private String casServerLoginUrl;
	//
	// @Value("${serverName}")
	// private String serverName;
	//
	// @Value(value = "${cas-ignore-patterns}")
	// private String casIgnorePatterns;

	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getSession(false).getId();
		return "sessionid: " + id;
	}
	//
	// @Bean
	// public FilterRegistrationBean casSingleSignOutFilter() {
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(new SingleSignOutFilter());
	// registration.addUrlPatterns("/*");
	// registration.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);
	// registration.setName("casSingleSignOutFilter");
	// registration.setOrder(1);
	// return registration;
	// }
	//
	// @Bean
	// public FilterRegistrationBean casAuthenticationFilter() {
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(new AuthenticationFilter());
	// registration.addUrlPatterns("/*");
	// Map<String, String> initParameters = new HashMap<String, String>();
	// initParameters.put("ignorePattern", casIgnorePatterns);
	// registration.setInitParameters(initParameters);
	// registration.addInitParameter("casServerLoginUrl", casServerLoginUrl);
	// registration.addInitParameter("serverName", serverName);
	// registration.setName("casAuthenticationFilter");
	// registration.setOrder(2);
	// return registration;
	// }
	//
	// @Bean
	// public FilterRegistrationBean casValidationFilter() {
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
	// registration.addUrlPatterns("/*");
	// registration.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);
	// registration.addInitParameter("serverName", serverName);
	// registration.addInitParameter("redirectAfterValidation", "true");
	// registration.addInitParameter("useSession", "true");
	// registration.addInitParameter("authn_method", "mfa-duo");
	// registration.setName("casValidationFilter");
	// registration.setOrder(3);
	// return registration;
	// }
	//
	// @Bean
	// public FilterRegistrationBean casHttpServletRequestWrapperFilter() {
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(new HttpServletRequestWrapperFilter());
	// registration.addUrlPatterns("/*");
	// registration.setName("casHttpServletRequestWrapperFilter");
	// registration.setOrder(4);
	// return registration;
	// }
	//
	// @Bean
	// public ServletListenerRegistrationBean<EventListener>
	// getSingleSignOutHttpSessionListener() {
	// ServletListenerRegistrationBean<EventListener> registrationBean = new
	// ServletListenerRegistrationBean<>();
	// registrationBean.setListener(new SingleSignOutHttpSessionListener());
	// return registrationBean;
	// }
}
