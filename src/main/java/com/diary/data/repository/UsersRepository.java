package com.diary.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diary.data.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}
