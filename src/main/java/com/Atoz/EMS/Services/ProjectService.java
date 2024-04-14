package com.Atoz.EMS.Services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Model.Entity.Employee;
import com.Atoz.EMS.Model.Entity.Project;
import com.Atoz.EMS.Repositories.EmployeeRepo;
import com.Atoz.EMS.Repositories.ProjectRepo;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepo projectRepository;
    private final EmployeeRepo employeeRepository;
    private final ModelMapper modelMapper;

    public ProjectService(ProjectRepo projectRepository, EmployeeRepo employeeRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;

    }

    public List<ProjectDTO> getProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(
                        project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    public ProjectDTO getProject(Long id) {
        Optional<Project> optProject = projectRepository.findById(id);
        return modelMapper.map(optProject, ProjectDTO.class);
    }

    public List<EmployeeDTO> getEmployeeAssigned(Long id) {
        Set<Employee> employees = projectRepository.findEmployeesByProjectId(id);
        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public ProjectDTO addNewProject(ProjectDTO dto) {
        Project project = modelMapper.map(dto, Project.class);
        System.out.println("New Project: " + project.toString());
        projectRepository.save(project);
        ProjectDTO projectDto = modelMapper.map(project, ProjectDTO.class);
        return projectDto;
    }

    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        return null;
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public ProjectDTO assignEmployeeProject(Long employeeId, Long projectId) {
        Set<Employee> employees = null;
        Employee employee = employeeRepository.findById(employeeId).get();
        Project project = projectRepository.findById(projectId).get();
        employees = project.getEmployees();
        employees.add(employee);
        project.setEmployees(employees);
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

}