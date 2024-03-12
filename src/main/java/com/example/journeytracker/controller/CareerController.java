package com.example.journeytracker.controller;

import com.example.journeytracker.payloads.CareerDto;
import com.example.journeytracker.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career")
public class CareerController {

	@Autowired
	private CareerService careerService;
	
	@PostMapping("/{scholarNo}")
	public ResponseEntity<CareerDto> createCareer(@RequestBody CareerDto careerDto, @PathVariable("scholarNo")String scholarNo){
		CareerDto createdCareer = this.careerService.createCareer(careerDto, scholarNo);
		return new ResponseEntity<CareerDto>(createdCareer,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CareerDto> updateCareer(@RequestBody CareerDto careerDto, @PathVariable("id")Integer id){
		CareerDto career = this.careerService.updateCareer(careerDto, id);
		return ResponseEntity.ok(career);
	}
	
	@GetMapping("/careerId/{id}")
	public ResponseEntity<CareerDto> getCareerById(@PathVariable("id")Integer id){
		CareerDto career = this.careerService.getCareerById(id);
		return ResponseEntity.ok(career);
	}
	
	@GetMapping("/scholarId/{scholarNo}")
	public ResponseEntity<CareerDto> getCareerByScholar(@PathVariable("scholarNo")String scholarNo){
		CareerDto career = this.careerService.getCareerByScholar(scholarNo);
		return ResponseEntity.ok(career);
	}
	
}
