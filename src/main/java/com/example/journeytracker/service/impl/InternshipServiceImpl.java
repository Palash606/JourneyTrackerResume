package com.example.journeytracker.service.impl;

import com.example.journeytracker.entity.Internship;
import com.example.journeytracker.entity.StudentPersonel;
import com.example.journeytracker.exception.ResourceNotFoundException;
import com.example.journeytracker.exception.ResourceNotFoundExceptionAll;
import com.example.journeytracker.payloads.InternshipDto;
import com.example.journeytracker.repository.InternshipRepo;
import com.example.journeytracker.repository.StudentPersonelRepo;
import com.example.journeytracker.service.InternshipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternshipServiceImpl implements InternshipService {

    @Autowired
    private InternshipRepo internshipRepo;

    @Autowired
    private StudentPersonelRepo studentPersonelRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public InternshipDto createInternship(InternshipDto internshipDto, String scholar) {
        // TODO Auto-generated method stub
        StudentPersonel student = this.studentPersonelRepo.findById(scholar).orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
        Internship intern = this.dtoToInternship(internshipDto);
        intern.setScholarNo(student);
        Internship savedIntern = this.internshipRepo.save(intern);
        return this.internshipToDto(savedIntern);
    }

    @Override
    public InternshipDto updateInternship(InternshipDto internshipDto, Integer id) {
        // TODO Auto-generated method stub
        Internship intern = this.internshipRepo.findById(id).orElseThrow(() -> new ResourceNotFoundExceptionAll("Achievement", "Id", id));
        intern.setOrgName(internshipDto.getOrgName());
        intern.setDescription(internshipDto.getDescription());
        intern.setTrName(internshipDto.getTrName());
        intern.setTrStartDate(internshipDto.getTrStartDate());
        intern.setTrEndDate(internshipDto.getTrEndDate());
        intern.setCertiUrl(internshipDto.getCertiUrl());
        Internship updatedInter = this.internshipRepo.save(intern);
        return this.internshipToDto(updatedInter);
    }

    @Override
    public List<InternshipDto> getInternshipByScholar(String scholar) {

        StudentPersonel student = this.studentPersonelRepo.findById(scholar).orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
        List<Internship> list = this.internshipRepo.findByScholarNo(student);
        List<InternshipDto> internDto = list.stream().map(a -> this.internshipToDto(a)).collect(Collectors.toList());

        return internDto;
    }

    @Override
    public List<InternshipDto> getAllInternship() {

        List<Internship> list = this.internshipRepo.findAll();
        List<InternshipDto> internDto = list.stream().map(a -> this.internshipToDto(a)).collect(Collectors.toList());
        return internDto;
    }


    @Override
    public void deleteInternship(Integer id) {
        // TODO Auto-generated method stub
        Internship intern = this.internshipRepo.findById(id).orElseThrow(() -> new ResourceNotFoundExceptionAll("Achievement", "Id", id));
        this.internshipRepo.delete(intern);

    }

    public Internship dtoToInternship(InternshipDto internshipDto) {
        Internship inter = this.modelMapper.map(internshipDto, Internship.class);
        return inter;
    }

    public InternshipDto internshipToDto(Internship intern) {
        InternshipDto internDto = this.modelMapper.map(intern, InternshipDto.class);
        return internDto;

    }


}
