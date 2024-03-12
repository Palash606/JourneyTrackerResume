package com.example.journeytracker.repository;

import com.example.journeytracker.entity.Curricular;
import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurricularRepo extends JpaRepository<Curricular, Integer>{
	
	List<Curricular> findByScholarNo(StudentPersonel student);

}
