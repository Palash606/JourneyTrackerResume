package com.example.journeytracker.service.impl;

import com.example.journeytracker.entity.StudentPersonel;
import com.example.journeytracker.helper.ExcelHelperStudents;
import com.example.journeytracker.payloads.StudentPersonelDto;
import com.example.journeytracker.repository.StudentPersonelRepo;
import com.example.journeytracker.service.ExcelServiceStudent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcelServiceStudentImpl implements ExcelServiceStudent {

    @Autowired
    private StudentPersonelRepo studentPersonelRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentPersonelDto> createAllStudent(MultipartFile file) {
        // TODO Auto-generated method stub
        List<StudentPersonel> studentBasicDetailsList = null;
        List<StudentPersonelDto> studentDto = null;
        try {
            studentBasicDetailsList = ExcelHelperStudents.convertExcelToListOfStudents(file.getInputStream());
            List<StudentPersonel> list = this.studentPersonelRepo.saveAll(studentBasicDetailsList);
            studentDto = list.stream().map(st -> this.studentToDto(st)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentDto;
    }

    public StudentPersonel dtoToStudent(StudentPersonelDto studentPersonelDto) {

        StudentPersonel st = this.modelMapper.map(studentPersonelDto, StudentPersonel.class);
        return st;
    }

    public StudentPersonelDto studentToDto(StudentPersonel studentPersonel) {

        StudentPersonelDto studentPersonelDto = this.modelMapper.map(studentPersonel, StudentPersonelDto.class);
        return studentPersonelDto;

    }

}
