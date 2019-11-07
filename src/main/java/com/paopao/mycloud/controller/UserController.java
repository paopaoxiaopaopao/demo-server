package com.paopao.mycloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paopao.mycloud.service.UserService;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = { "test" })
	public Object test() {
		return "this is a test api";
	}


}
