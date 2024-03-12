package com.example.journeytracker.service.impl;

import com.example.journeytracker.entity.Achievement;
import com.example.journeytracker.entity.StudentPersonel;
import com.example.journeytracker.exception.ResourceNotFoundException;
import com.example.journeytracker.exception.ResourceNotFoundExceptionAll;
import com.example.journeytracker.payloads.AchievementDto;
import com.example.journeytracker.repository.AchievementRepo;
import com.example.journeytracker.repository.StudentPersonelRepo;
import com.example.journeytracker.service.AchievementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private StudentPersonelRepo studentPersonelRepo;

    @Autowired
    private AchievementRepo achievementRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AchievementDto createAchievement(AchievementDto achievementDto, String scholarNo) {

        StudentPersonel student = this.studentPersonelRepo.findById(scholarNo).orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
        Achievement achieve = this.dtoToAchievement(achievementDto);
        achieve.setScholarNo(student);
        Achievement savedAchieve = this.achievementRepo.save(achieve);
        return this.achievementToDto(savedAchieve);
    }

    @Override
    public AchievementDto updateAchievement(AchievementDto achievementDto, Integer id) {

        Achievement achieve = this.achievementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundExceptionAll("Achievement", "Id", id));
        achieve.setAchieve(achievementDto.getAchieve());
        Achievement updatedAchieve = this.achievementRepo.save(achieve);
        return this.achievementToDto(updatedAchieve);
    }

    @Override
    public List<AchievementDto> getAchievementByScholar(String scholar) {
        StudentPersonel student = this.studentPersonelRepo.findById(scholar).orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
        List<Achievement> achieveList = this.achievementRepo.findByScholarNo(student);
        List<AchievementDto> list = achieveList.stream().map(achieve -> this.achievementToDto(achieve)).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<AchievementDto> getAllAchievement() {
        List<Achievement> achieve = this.achievementRepo.findAll();
        List<AchievementDto> list = achieve.stream().map(a -> this.achievementToDto(a)).collect(Collectors.toList());

        return list;
    }

    @Override
    public void deleteAchievement(Integer id) {
        Achievement achieve = this.achievementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundExceptionAll("Achievement", "Id", id));
        this.achievementRepo.delete(achieve);

    }

    public Achievement dtoToAchievement(AchievementDto achieveDto) {
        Achievement achieve = this.modelMapper.map(achieveDto, Achievement.class);
        return achieve;
    }

    public AchievementDto achievementToDto(Achievement achieve) {
        AchievementDto achieveDto = this.modelMapper.map(achieve, AchievementDto.class);
        return achieveDto;

    }
}
