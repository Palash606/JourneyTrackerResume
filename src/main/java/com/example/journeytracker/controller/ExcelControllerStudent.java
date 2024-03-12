package com.example.journeytracker.controller;

import com.example.journeytracker.helper.ExcelHelperStudents;
import com.example.journeytracker.payloads.StudentPersonelDto;
import com.example.journeytracker.service.ExcelServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ExcelControllerStudent {
    @Autowired
    private ExcelServiceStudent excelServiceStudent;

    @PostMapping("/admin/uploadStudentExcel")
    public ResponseEntity<List<StudentPersonelDto>> upload(@RequestParam("file") MultipartFile file) {
        List<StudentPersonelDto> studentList = null;

        if (ExcelHelperStudents.checkExcelFormat(file)) {
            studentList = this.excelServiceStudent.createAllStudent(file);
        } else {
            System.out.println("something wrong");
        }
        return new ResponseEntity<List<StudentPersonelDto>>(studentList, HttpStatus.CREATED);
    }


}

