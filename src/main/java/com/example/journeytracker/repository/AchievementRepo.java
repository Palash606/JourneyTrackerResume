package com.example.journeytracker.repository;

import com.example.journeytracker.entity.Achievement;
import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepo extends JpaRepository<Achievement, Integer> {
	
	List<Achievement> findByScholarNo(StudentPersonel student);
	
}
