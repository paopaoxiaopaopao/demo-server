package com.paopao.mycloud.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.paopao.mycloud.common.SystemUser;

@RestController
public class BaseController {

	public static final String RESPONSE_SUCCESS = "success";

	public static final String RESPONSE_FAILED = "failed";

	protected static Logger logger = LoggerFactory.getLogger(BaseController.class);

	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	protected SystemUser getSystemUser() {
		Principal principal = getRequest().getUserPrincipal();
		if (principal != null) {
			AttributePrincipal attributePrincipal = (AttributePrincipal) principal;
			String jsonString = JSON.toJSONString(attributePrincipal.getAttributes());
			SystemUser systemUser = JSON.parseObject(jsonString, SystemUser.class);
			logger.info("当前登录人信息：" + systemUser.toString());
			return systemUser;
		} else {
			logger.info("登录信息不存在!");
			return null;
		}
	}

	protected boolean checkSystemUser() {
		SystemUser systemUser = this.getSystemUser();
		if (systemUser == null) {
			return false;
		}
		return true;
	}

}
