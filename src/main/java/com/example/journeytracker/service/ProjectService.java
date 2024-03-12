package com.example.journeytracker.service;


import com.example.journeytracker.payloads.ProjectDto;

import java.util.List;

public interface ProjectService {

	ProjectDto createProject(ProjectDto skillDto, String scholar);

	ProjectDto updateProject(ProjectDto skillDto, Integer id);

	List<ProjectDto> getProjectByScholar(String scholar);

	List<ProjectDto> getAllProject();

	void deleteProject(Integer id);
	
}
