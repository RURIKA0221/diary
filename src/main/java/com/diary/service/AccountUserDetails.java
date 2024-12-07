package com.diary.service;

import java.time.LocalDate;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.diary.data.entity.Users;

public class AccountUserDetails implements UserDetails{
	private Users user;

	public AccountUserDetails(Users user) {
		this.user = user;
	}

	// パスワードを返却する
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	// ユーザー名を返却する
	@Override
	public String getUsername() {
		return user.getUserName();
	}

	// アカウントの有効期限の状態を判定する
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// アカウントのロック状態を判定する
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 資格情報の有効期限の状態を判定する
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 有効なユーザかを判定する
	@Override
	public boolean isEnabled() {
		return true;
	}

	// Entityを返す
	public Users getUser() {
		return user;
	}

	// 名前を返す
	public String getName() {
		return user.getName();
	}

	@Override
	public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public LocalDate getBirthday() {
		return user.getBirthday();
	}
}
