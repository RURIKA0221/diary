package com.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.diary.data.entity.Users;
import com.diary.data.repository.UsersRepository;
import com.diary.form.UserForm;

@Controller
public class SignupController {

	@Autowired
	private UsersRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@GetMapping("/signup")
	String signupForm() {
		return "signup";
	}

	@PostMapping("/signup")
	public String Signup(@Validated UserForm userForm, Model model) {

		if (!userForm.getPassword().equals(userForm.getPassword2())) {
			model.addAttribute("passwordError", true);
			return "signup";
		}

		String hashedPassword = passwordEncoder.encode(userForm.getPassword());

		Users user = new Users();
		user.setUserName(userForm.getUserName());
		user.setName(userForm.getName());
		user.setBirthday(userForm.getBirthday());
		user.setPassword(hashedPassword); // 初期状態では未完了
		repo.save(user);

		// ログイン画面にリダイレクト
		return "redirect:/signupSuccess";
	}

	// 新規登録完了後の画面表示
	@GetMapping("/signupSuccess")
	public String signupSuccess() {
		return "signupSuccess"; // signupSuccess.html
	}
}