package com.Atoz.EMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Model.Entity.Project;
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

    // Assign a employee to a project
    @PutMapping("/{id}/assign-employee")
    public ProjectDTO assignEmployee(@RequestParam Long projectId, @RequestBody EmployeeDTO employeeDTO) {
        return projectService.assignEmployeeProject(projectId, employeeDTO);
    }

    // Update the project
    @PutMapping("/{id}")
    public ProjectDTO putMethodName(@PathVariable Long id, @RequestBody ProjectDTO dto) {
        return projectService.updateProject(id, dto);
    }

    // Delete a project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    @DeleteMapping("/{id}/remove-employee/{empId}")
    public ProjectDTO removeEmployeeFromProject(@PathVariable Long id, @PathVariable Long empId) {
        return projectService.removeEmployeeFromProject(id, empId);
    }

}
