package com.diary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.diary.service.AccountUserDetailsService;

@Configuration
@EnableWebSecurity
public class GrobalConfig {
	@Autowired
	public void config(PasswordEncoder passwordEncoder,AuthenticationManagerBuilder auth,AccountUserDetailsService userDetailsService) throws Exception {
		auth.eraseCredentials(true).userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		
	}
}
