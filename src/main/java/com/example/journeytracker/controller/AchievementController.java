package com.example.journeytracker.controller;

import com.example.journeytracker.payloads.AchievementDto;
import com.example.journeytracker.payloads.ApiResponse;

import com.example.journeytracker.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/resume/achievement")
public class AchievementController {

	@Autowired
	private AchievementService achievementService;
	
	@PostMapping("/scholar/{scholarId}")
	public ResponseEntity<AchievementDto> createAchievement(@RequestBody AchievementDto achievementDto,@PathVariable("scholarId") String scholarId){
		
		AchievementDto achieve = this.achievementService.createAchievement(achievementDto, scholarId);
		
		return new ResponseEntity<AchievementDto>(achieve,HttpStatus.CREATED);
	}
	
	@PutMapping("/achieve/{achieveId}")
	public ResponseEntity<AchievementDto> updateAchievement(@RequestBody AchievementDto achievementDto,@PathVariable("achieveId") Integer achieveId){
		AchievementDto achieve = this.achievementService.updateAchievement(achievementDto, achieveId);
		return new ResponseEntity<AchievementDto>(achieve,HttpStatus.OK);
	}
	
	@DeleteMapping("/achieve/{achieveId}")
	public  ApiResponse deleteAchievement(@PathVariable("achieveId") Integer achieveId){
		this.achievementService.deleteAchievement(achieveId);
		return new ApiResponse("Achievement deleted successfully",true);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AchievementDto>> getAllAchieve(){
		List<AchievementDto> allAchieve = this.achievementService.getAllAchievement();
		return new ResponseEntity<List<AchievementDto>>(allAchieve,HttpStatus.OK);
	}
	
	@GetMapping("/scholarId/{scholarId}")
	public ResponseEntity<List<AchievementDto>> getAllAchieveByScholar(@PathVariable("scholarId") String scholarId){
		List<AchievementDto> allAchieveByScholar = this.achievementService.getAchievementByScholar(scholarId);
		return new ResponseEntity<List<AchievementDto>>(allAchieveByScholar,HttpStatus.OK);
	}
	
	
}
