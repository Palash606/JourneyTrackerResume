package com.example.journeytracker.repository;

import com.example.journeytracker.entity.Certificate;
import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepo extends JpaRepository<Certificate, Integer>{

	List<Certificate> findByScholarNo(StudentPersonel student);
	
}
