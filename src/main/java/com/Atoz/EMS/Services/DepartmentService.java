package com.Atoz.EMS.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.DepartmentDTO;
import com.Atoz.EMS.Model.Entity.Department;
import com.Atoz.EMS.Repositories.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepository;

    // Fetch all departments
    public List<DepartmentDTO> getAllDepartments() {
        return convertToDTOs(departmentRepository.findAll());
    }

    // Insert a new department
    public DepartmentDTO addNewDepartment(DepartmentDTO dto) {
        Department department = convertDepartmentDTOToEntity(dto);
        departmentRepository.save(department);
        return dto;
    }

    // Delete the department
    public void deleteDepartment(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDepartment'");
    }

    // Fetch a department
    public DepartmentDTO getDepartmentById(Long id) {
        Optional<Department> optDepartment = departmentRepository.findById(id);
        if (optDepartment.isPresent()) {
            Department department = optDepartment.get();
            return convertToDTO(department);
        }
        return null;
    }

    // Convert Entity to Data Transfer Object
    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO(
                department.getId(),
                department.getDepartmentName());
        return dto;
    }

    // Convert Entity to Data Transfer Object but Collection
    private List<DepartmentDTO> convertToDTOs(List<Department> departments) {
        return departments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert Data Transfer Object to Entity
    protected Department convertDepartmentDTOToEntity(DepartmentDTO dto) {
        return new Department(dto.getId(), dto.getDepartmentName());
    }
}