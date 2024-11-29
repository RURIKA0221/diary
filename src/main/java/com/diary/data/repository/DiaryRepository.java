package com.diary.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.diary.data.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Integer>{
	@Query("select a from Diary a where a.date between :from and :to and name = :name")

	List<Diary> findByDateBetween(@Param("from") LocalDate from, @Param("to") LocalDate to, @Param("name") String name);

	@Query("select b from Diary b where b.date between :from and :to")

	List<Diary> findByDateBetween2(@Param("from") LocalDate from, @Param("to") LocalDate to);
}
