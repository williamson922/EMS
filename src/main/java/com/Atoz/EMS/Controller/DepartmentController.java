package com.Atoz.EMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Atoz.EMS.Model.DTO.DepartmentDTO;
import com.Atoz.EMS.Services.DepartmentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();

    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartment(Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentDTO addNewDepartment(DepartmentDTO newDepartment) {
        return departmentService.addNewDepartment(newDepartment);
    }

    @DeleteMapping
    public void deleteDepartment(Long id) {
        departmentService.deleteDepartment(id);
    }

}
