package com.example.journeytracker.controller;

import com.example.journeytracker.payloads.ApiResponse;
import com.example.journeytracker.payloads.StudentPersonelDto;
import com.example.journeytracker.service.StudentPersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resume")
public class StudentPersonelController {

    @Autowired
    private StudentPersonelService studentPersonelService;

    @PutMapping("/update/{scholarNo}")
    public ResponseEntity<StudentPersonelDto> updateStudent(@RequestBody StudentPersonelDto studentPersonelDto, @PathVariable("scholarNo") String scholarNo) {

        StudentPersonelDto updatedStudent = this.studentPersonelService.updateStudent(studentPersonelDto, scholarNo);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{scholarNo}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("scholarNo") String scholarNo) {
        this.studentPersonelService.deleteStudent(scholarNo);
        return new ResponseEntity<ApiResponse>(new ApiResponse("student deleted successfully", true), HttpStatus.OK);

    }

    @GetMapping("/studentId/{scholarNo}")
    public ResponseEntity<StudentPersonelDto> getStudentByScholar(@PathVariable("scholarNo") String scholarNo) {
        StudentPersonelDto student = this.studentPersonelService.getStudentById(scholarNo);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/allStudent")
    public ResponseEntity<List<StudentPersonelDto>> getAllStudent() {
        return ResponseEntity.ok(this.studentPersonelService.getAllStudents());
    }


}
