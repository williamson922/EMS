package com.Atoz.EMS.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.Entity.Employee;
import com.Atoz.EMS.Repositories.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    // Fetch all employees
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return convertToDTOs(employees);
    }

    // Fetch an employee by ID
    public EmployeeDTO getEmployee(Long id) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            return convertToDTO(employee);
        }

        return null;
    }

    // Insert an employee
    public EmployeeDTO addNewEmployee(EmployeeDTO dto) {
        Employee employee = convertEmployeeDTOToEntity(dto);
        employeeRepository.save(employee);
        return dto;

    }

    // Modify the information of an employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {

        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

    }

    // Utility methods to convert between entity and DTO
    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setPosition(employee.getPosition());
        dto.setDepartmentId(employee.getDepartment().getId());
        return dto;
    }

    private List<EmployeeDTO> convertToDTOs(List<Employee> employees) {
        return employees.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Employee convertEmployeeDTOToEntity(EmployeeDTO dto) {
        Employee employee = new Employee(
                dto.getId(),
                dto.getName(),
                dto.getPosition(),
                departmentService
                        .convertDepartmentDTOToEntity(departmentService.getDepartmentById(dto.getDepartmentId())));
        return employee;
    }
}
