package com.diary.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserForm {
	private String userName;
	private String display_name;
	private LocalDate birthday;
	private String password;
	private String password2;

}
