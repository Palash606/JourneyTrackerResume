package com.example.journeytracker.service;


import com.example.journeytracker.payloads.SkillDto;

import java.util.List;

public interface SkillService {

    SkillDto createSkill(SkillDto skillDto, String scholar);

    SkillDto updateSkill(SkillDto skillDto, Integer id);

    List<SkillDto> getSkillByScholar(String scholar);

    List<SkillDto> getAllSkill();

    void deleteSkill(Integer id);

}
