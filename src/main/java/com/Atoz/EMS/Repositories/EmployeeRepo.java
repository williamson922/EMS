package com.Atoz.EMS.Repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Atoz.EMS.Model.Entity.Employee;
import com.Atoz.EMS.Model.Entity.Project;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("SELECT p FROM Project p JOIN p.employees e WHERE e.id = :employeeId")
    Set<Project> findProjectsByEmployeeId(@Param("employeeId") Long employeeId);

    Set<Employee> findAllById(Long id);
}
