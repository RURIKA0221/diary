package com.diary.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
	@GetMapping("/loginForm")
	String loginForm() {
		return "login";
	}
}
