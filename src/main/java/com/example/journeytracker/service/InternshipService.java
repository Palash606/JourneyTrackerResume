package com.example.journeytracker.service;


import com.example.journeytracker.payloads.InternshipDto;

import java.util.List;

public interface InternshipService {

    InternshipDto createInternship(InternshipDto internshipDto, String scholar);

    InternshipDto updateInternship(InternshipDto internshipDto, Integer id);

    List<InternshipDto> getInternshipByScholar(String scholar);

    List<InternshipDto> getAllInternship();

    void deleteInternship(Integer id);

}
