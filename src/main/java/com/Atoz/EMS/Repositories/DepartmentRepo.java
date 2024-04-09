package com.Atoz.EMS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Atoz.EMS.Model.Entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
