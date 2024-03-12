package com.example.journeytracker.repository;

import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPersonelRepo extends JpaRepository<StudentPersonel, String> {

}
