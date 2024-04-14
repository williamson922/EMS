package com.Atoz.EMS.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.DepartmentDTO;
import com.Atoz.EMS.Model.Entity.Department;
import com.Atoz.EMS.Repositories.DepartmentRepo;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepo departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    // Fetch all departments
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    // Fetch a department
    public DepartmentDTO getDepartmentById(Long id) {
        Optional<Department> optDepartment = departmentRepository.findById(id);
        return modelMapper.map(optDepartment, DepartmentDTO.class);
    }

    // Insert a new department
    public DepartmentDTO addNewDepartment(DepartmentDTO dto) {
        Department department = modelMapper.map(dto, Department.class);
        departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDTO.class);
    }

    // Delete the department
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}