package com.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diary.data.entity.Users;
import com.diary.data.repository.UsersRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if (userName == null || "".equals(userName)) {
			throw new UsernameNotFoundException("ユーザー名が空です");
		}
		
		// データベースからユーザーを取得し、存在しない場合に例外をスロー
        Users user = repository.findById(userName)
            .orElseThrow(() -> new UsernameNotFoundException(userName + "は見つかりません。"));

        // ユーザーが存在する場合は、UserDetailsの実装クラスを返す
        return new AccountUserDetails(user);
		
	}
}
