package com.example.journeytracker.service;


import com.example.journeytracker.payloads.CurricularDto;

import java.util.List;

public interface CurricularService {

	CurricularDto createCurricular(CurricularDto curricularDto, String scholarNo);
	CurricularDto updateCurricular(CurricularDto curricularDto, Integer id);
	List<CurricularDto> getCurricularByScholar(String scholar);
	List<CurricularDto> getAllCurricular();
	void deleteCurricular(Integer id);
	
}
