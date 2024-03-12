package com.example.journeytracker.service.impl;

import com.example.journeytracker.entity.StudentPersonel;
import com.example.journeytracker.exception.ResourceNotFoundException;
import com.example.journeytracker.payloads.StudentPersonelDto;
import com.example.journeytracker.repository.StudentPersonelRepo;
import com.example.journeytracker.service.StudentPersonelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentPersonelServiceImpl implements StudentPersonelService {

    @Autowired
    private StudentPersonelRepo studentPersonelRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public StudentPersonelDto updateStudent(StudentPersonelDto studentPersonelDto, String scholarNo) {

        StudentPersonel st = this.studentPersonelRepo.findById(scholarNo).orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));

        st.setStudentName(studentPersonelDto.getStudentName());
        st.setStudentPassword(studentPersonelDto.getStudentPassword());
        st.setGender(studentPersonelDto.getGender());
        st.setStudentDept(studentPersonelDto.getStudentDept());
        st.setStudentSemester(studentPersonelDto.getStudentSemester());
        st.setStudentSection(studentPersonelDto.getStudentSection());
        st.setStudentPersonalEmail(studentPersonelDto.getStudentPersonalEmail());
        st.setStudentGithub(studentPersonelDto.getStudentGithub());
        st.setStudentLinkedin(studentPersonelDto.getStudentLinkedin());
        st.setStudentAddress(studentPersonelDto.getStudentAddress());
        st.setStudentPhone(studentPersonelDto.getStudentPhone());
        st.setStudentCategory(studentPersonelDto.getStudentCategory());
        st.setDob(studentPersonelDto.getDob());

        StudentPersonel updatedStudent = this.studentPersonelRepo.save(st);
        StudentPersonelDto studentDto = this.studentToDto(updatedStudent);
        return studentDto;
    }

    @Override
    public StudentPersonelDto getStudentById(String scholarNo) {
        // TODO Auto-generated method stub
        StudentPersonel st = this.studentPersonelRepo.findById(scholarNo).orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
        StudentPersonelDto studentDto = this.studentToDto(st);
        return studentDto;
    }

    @Override
    public List<StudentPersonelDto> getAllStudents() {
        List<StudentPersonel> studentList = this.studentPersonelRepo.findAll();
        List<StudentPersonelDto> studentDtoList = studentList.stream().map(st -> this.studentToDto(st)).collect(Collectors.toList());
        return studentDtoList;
    }

    @Override
    public void deleteStudent(String scholarNo) {
        StudentPersonel st = this.studentPersonelRepo.findById(scholarNo).orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
        this.studentPersonelRepo.delete(st);

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
