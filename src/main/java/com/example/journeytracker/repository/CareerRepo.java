package com.example.journeytracker.repository;

import com.example.journeytracker.entity.Career;
import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepo extends JpaRepository<Career, Integer>{

	
	Career findByScholarNo(StudentPersonel student);
	
}
