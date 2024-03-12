package com.example.journeytracker.service;

import com.example.journeytracker.payloads.StudentPersonelDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelServiceStudent {

    public List<StudentPersonelDto> createAllStudent(MultipartFile file);

}
