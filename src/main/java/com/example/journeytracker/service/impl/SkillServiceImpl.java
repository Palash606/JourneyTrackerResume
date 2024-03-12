package com.example.journeytracker.service.impl;

import com.example.journeytracker.entity.Skill;
import com.example.journeytracker.entity.StudentPersonel;
import com.example.journeytracker.exception.ResourceNotFoundException;
import com.example.journeytracker.exception.ResourceNotFoundExceptionAll;
import com.example.journeytracker.payloads.SkillDto;
import com.example.journeytracker.repository.SkillRepo;
import com.example.journeytracker.repository.StudentPersonelRepo;
import com.example.journeytracker.service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentPersonelRepo studentPersonelRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Override
    public SkillDto createSkill(SkillDto skillDto, String scholar) {
        StudentPersonel student = this.studentPersonelRepo.findById(scholar)
                .orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
        Skill skill = this.dtoToSkill(skillDto);
        skill.setScholarNo(student);
        Skill savedSkill = this.skillRepo.save(skill);
        return this.skillToDto(savedSkill);
    }

    @Override
    public SkillDto updateSkill(SkillDto skillDto, Integer id) {
        Skill skill = this.skillRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionAll("Skill", "Id", id));
        skill.setSkillName(skillDto.getSkillName());
        Skill updatedSkill = this.skillRepo.save(skill);
        return this.skillToDto(updatedSkill);
    }

    @Override
    public List<SkillDto> getSkillByScholar(String scholar) {
        StudentPersonel student = this.studentPersonelRepo.findById(scholar)
                .orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
        List<Skill> skillList = this.skillRepo.findByScholarNo(student);
        List<SkillDto> list = skillList.stream().map(skill -> this.skillToDto(skill))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<SkillDto> getAllSkill() {
        List<Skill> skillList = this.skillRepo.findAll();
        List<SkillDto> list = skillList.stream().map(skill -> this.skillToDto(skill))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void deleteSkill(Integer id) {
        Skill skill = this.skillRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionAll("Skill", "Id", id));
        this.skillRepo.delete(skill);

    }

    public Skill dtoToSkill(SkillDto skillDto) {
        Skill skill = this.modelMapper.map(skillDto, Skill.class);
        return skill;
    }

    public SkillDto skillToDto(Skill skill) {
        SkillDto skillDto = this.modelMapper.map(skill, SkillDto.class);
        return skillDto;

    }

}
