package com.diary.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.diary.data.entity.Users;

public class SignupController {
	@GetMapping("/signup")
	String signupForm() {
		return "signup";
	}
	
    @PostMapping("/signup")
    public String Signup(Users user, @PathVariable String password2, String password, Model model) {
        if (password.equals(password2)) {
            model.addAttribute("passwordError", true); 
            return "signup";
        }

        // ログイン画面にリダイレクト
        return "redirect:/login";
    }
}
