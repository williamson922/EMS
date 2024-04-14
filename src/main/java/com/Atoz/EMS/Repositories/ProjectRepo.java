package com.Atoz.EMS.Repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Atoz.EMS.Model.Entity.Employee;
import com.Atoz.EMS.Model.Entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    @Query("SELECT e FROM Employee e JOIN e.projects p WHERE p.id = :project_id")
    Set<Employee> findEmployeesByProjectId(@Param("project_id") Long id);
}
