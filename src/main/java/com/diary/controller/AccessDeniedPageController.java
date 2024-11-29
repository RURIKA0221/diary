package com.diary.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AccessDeniedPageController {
	 @GetMapping("/accessDeniedPage")
	    public String accessDeniedPage() {
	        return "accessDeniedPage";
	    }
}
