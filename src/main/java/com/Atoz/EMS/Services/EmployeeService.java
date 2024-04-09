package com.Atoz.EMS.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.Entity.Employee;
import com.Atoz.EMS.Repositories.EmployeeRepo;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private DepartmentService departmentService;

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
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        return optEmployee.map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .orElse(null);
    }

    // Insert an employee
    public EmployeeDTO addNewEmployee(EmployeeDTO dto) {
        dto.setId(null);
        Employee employee = modelMapper.map(dto, Employee.class);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    // Modify the information of an employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {

        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
