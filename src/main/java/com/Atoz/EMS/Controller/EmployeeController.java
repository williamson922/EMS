package com.Atoz.EMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Services.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // CRUD endpoints
    // Fetch an employee
    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    // Add a new employee
    @PostMapping("/save")
    public EmployeeDTO addNewEmployee(EmployeeDTO dto) {
        return employeeService.addNewEmployee(dto);
    }

    // Edit the employee
    @PutMapping("/{id}")
    public EmployeeDTO UpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return employeeService.updateEmployee(id, dto);
    }

    // Delete a employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
    }

}
