package com.Atoz.EMS.Services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Model.Entity.Employee;
import com.Atoz.EMS.Model.Entity.Project;
import com.Atoz.EMS.Repositories.EmployeeRepo;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // Fetch all employees
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    // Fetch an employee by ID
    public EmployeeDTO getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        return modelMapper.map(employee, EmployeeDTO.class);
    }

    // Fetch the Projects which the employee assigned.
    public Set<ProjectDTO> getProjects(Long id) {
        Set<Project> projects = employeeRepository.findProjectsByEmployeeId(id);
        return projects.stream().map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toSet());
    }

    // Insert an employee
    public EmployeeDTO addNewEmployee(EmployeeDTO dto) {
        Employee employee = modelMapper.map(dto, Employee.class);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    // Modify the information of an employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {

        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    // Delete an employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
