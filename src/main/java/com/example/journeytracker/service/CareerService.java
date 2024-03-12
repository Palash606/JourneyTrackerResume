package com.example.journeytracker.service;

import com.example.journeytracker.payloads.CareerDto;

public interface CareerService {

	CareerDto createCareer(CareerDto careerDto, String scholarNo);
	CareerDto updateCareer(CareerDto careerDto, Integer cid);
	CareerDto getCareerById(Integer cid);
	CareerDto getCareerByScholar(String scholarNo);
	
}
