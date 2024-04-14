package com.Atoz.EMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Services.ProjectService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getProjects() {
        return projectService.getProjects();
    }

    // Fetch a project
    @GetMapping("/{id}")
    public ProjectDTO getProject(@RequestParam Long id) {
        return projectService.getProject(id);
    }

    // //Fetch the list of employees who are currently assigned in the project
    @GetMapping("/{id}/employees")
    public List<EmployeeDTO> getEmployeeAssigned(Long id) {
        return projectService.getEmployeeAssigned(id);
    }

    // Insert a new project
    @PostMapping("/save")
    public ProjectDTO addNewProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.addNewProject(projectDTO);
    }

    // Update a project
    @PutMapping("/{id}/assign-employee/{empid}")
    public ProjectDTO assignEmployee(Long employeeId, Long projectId) {
        return projectService.assignEmployeeProject(employeeId, projectId);
    }

    // Delete a project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

}
