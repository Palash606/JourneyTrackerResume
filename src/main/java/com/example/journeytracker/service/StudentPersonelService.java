package com.example.journeytracker.service;


import com.example.journeytracker.payloads.StudentPersonelDto;

import java.util.List;

public interface StudentPersonelService {
	
	public StudentPersonelDto updateStudent(StudentPersonelDto studentPersonelDto, String scholarNo);
	public StudentPersonelDto getStudentById(String scholarNo);
	public List<StudentPersonelDto> getAllStudents();
	public void deleteStudent(String scholarNo);
	

}
