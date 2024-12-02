package com.diary.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.diary.data.entity.Diary;
import com.diary.data.repository.DiaryRepository;
import com.diary.form.DiaryForm;
import com.diary.service.AccountUserDetails;
@Controller
public class CreateController {

	@Autowired
	private DiaryRepository diary;

	@GetMapping("main/create/{date}")
	String createForm(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, Model model) {
		// モデルにフォーム用データを設定
		model.addAttribute("date", date);
		return "create";
	}

	@PostMapping("main/create")
	String createTasks(@Validated DiaryForm diaryForm, @AuthenticationPrincipal AccountUserDetails user, Model model) {

		model.addAttribute("tasks", diary);
		model.addAttribute("taskForm", diaryForm);

		Diary log = new Diary();
		log.setName(user.getName());
		log.setTitle(diaryForm.getTitle());
		log.setText(diaryForm.getText());
		log.setDate(diaryForm.getDate());

		diary.save(log);

		return "redirect:/main";
	}
}
