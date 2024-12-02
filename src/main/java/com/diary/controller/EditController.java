package com.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class EditController {
	@Autowired
	private DiaryRepository diary;

	@GetMapping("main/edit/{id}")
	String editForm(@PathVariable Integer id, Model model) {
		// タスクIDに基づいてタスクを取得
		Diary log = diary.getById(id);
		model.addAttribute("task", log);
		return "edit";
	}

	@PostMapping("main/edit/{id}")
	String editTasks(@PathVariable Integer id, @Validated DiaryForm diaryForm,
			@AuthenticationPrincipal AccountUserDetails user, Model model) {

		// タスクIDに基づいてタスクを取得
		Diary log = diary.getById(id);
		
		model.addAttribute("tasks", log);
		model.addAttribute("taskForm", diaryForm);

		log.setName(user.getName());
		log.setTitle(diaryForm.getTitle());
		log.setText(diaryForm.getText());
		log.setDate(diaryForm.getDate());
		
		diary.save(log);

		return "redirect:/main";

	}

	@PostMapping("main/delete/{id}")
	String deleteTask(@PathVariable Integer id) {
		// タスクIDに基づいて削除
		diary.deleteById(id);
		return "redirect:/main";
	}
}
