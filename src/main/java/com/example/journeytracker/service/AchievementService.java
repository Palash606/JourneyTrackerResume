package com.example.journeytracker.service;

import com.example.journeytracker.payloads.AchievementDto;

import java.util.List;

public interface AchievementService {

    AchievementDto createAchievement(AchievementDto achievementDto, String scholarNo);

    AchievementDto updateAchievement(AchievementDto achievementDto, Integer id);

    List<AchievementDto> getAchievementByScholar(String scholar);

    List<AchievementDto> getAllAchievement();

    void deleteAchievement(Integer id);

}
