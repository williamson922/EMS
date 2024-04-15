package com.Atoz.EMS.Services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Model.Entity.Employee;
import com.Atoz.EMS.Model.Entity.Project;
import com.Atoz.EMS.Repositories.EmployeeRepo;
import com.Atoz.EMS.Repositories.ProjectRepo;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepo projectRepository;
    private final ModelMapper modelMapper;

    public ProjectService(ProjectRepo projectRepository, EmployeeRepo employeeRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
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
        Project project = projectRepository.findById(id).get();
        System.out.println(project.getEmployees());
        return modelMapper.map(project, ProjectDTO.class);
    }

    public List<EmployeeDTO> getEmployeeAssigned(Long id) {
        Set<Employee> employees = projectRepository.findEmployeesByProjectId(id);
        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public ProjectDTO addNewProject(ProjectDTO dto) {
        Project project = modelMapper.map(dto, Project.class);
        projectRepository.save(project);
        ProjectDTO projectDto = modelMapper.map(project, ProjectDTO.class);
        return projectDto;
    }

    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        Project project = projectRepository.findById(id).get();
        modelMapper.map(dto, project);
        ProjectDTO updatedDto = modelMapper.map(projectRepository.save(project), ProjectDTO.class);
        return updatedDto;
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public ProjectDTO assignEmployeeProject(Long projectId, EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Project project = projectRepository.findById(projectId).get();
        Set<Employee> employees = project.getEmployees();
        employees.add(employee);
        project.setEmployees(employees);
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

}