package com.example.journeytracker.repository;

import com.example.journeytracker.entity.Skill;
import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepo extends JpaRepository<Skill, Integer>{
	List<Skill> findByScholarNo(StudentPersonel student);


}
