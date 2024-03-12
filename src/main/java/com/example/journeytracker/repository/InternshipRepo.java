package com.example.journeytracker.repository;

import com.example.journeytracker.entity.Internship;
import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipRepo extends JpaRepository<Internship, Integer>{
	
	List<Internship> findByScholarNo(StudentPersonel student);

}
