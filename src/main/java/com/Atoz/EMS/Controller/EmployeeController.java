package com.Atoz.EMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Atoz.EMS.Model.DTO.EmployeeDTO;
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
    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public EmployeeDTO addNewEmployee(EmployeeDTO dto) {
        return employeeService.addNewEmployee(dto);
    }

    @PutMapping("/{id}")
    public EmployeeDTO UpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        // TODO: process PUT request
        return employeeService.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
    }

}
