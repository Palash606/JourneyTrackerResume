package com.example.journeytracker.controller;

import com.example.journeytracker.payloads.ApiResponse;
import com.example.journeytracker.payloads.ProjectDto;
import com.example.journeytracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/scholar/{scholarId}")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto,
                                                    @PathVariable("scholarId") String scholarId) {

        ProjectDto project = this.projectService.createProject(projectDto, scholarId);

        return new ResponseEntity<ProjectDto>(project, HttpStatus.CREATED);
    }

    @PutMapping("/projectId/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto,
                                                    @PathVariable("projectId") Integer projectId) {
        ProjectDto project = this.projectService.updateProject(projectDto, projectId);
        return new ResponseEntity<ProjectDto>(project, HttpStatus.OK);
    }

    @DeleteMapping("/projectId/{projectId}")
    public ApiResponse deleteProject(@PathVariable("projectId") Integer projectId) {
        this.projectService.deleteProject(projectId);
        return new ApiResponse("Project deleted successfully", true);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProjectDto>> getAllProject() {
        List<ProjectDto> allProject = this.projectService.getAllProject();
        return new ResponseEntity<List<ProjectDto>>(allProject, HttpStatus.OK);
    }

    @GetMapping("/scholarId/{scholarId}")
    public ResponseEntity<List<ProjectDto>> getAllProjectByScholar(@PathVariable("scholarId") String scholarId) {
        List<ProjectDto> allSkillByScholar = this.projectService.getProjectByScholar(scholarId);
        return new ResponseEntity<List<ProjectDto>>(allSkillByScholar, HttpStatus.OK);
    }


}
