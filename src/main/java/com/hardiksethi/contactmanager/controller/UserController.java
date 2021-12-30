package com.hardiksethi.contactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/index")
	public String dashboard() {
		return "user/user_dashboard";
	}
 }
