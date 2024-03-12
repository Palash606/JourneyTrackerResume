package com.example.journeytracker.repository;

import com.example.journeytracker.entity.Project;
import com.example.journeytracker.entity.StudentPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

    List<Project> findByScholarNo(StudentPersonel student);

}
