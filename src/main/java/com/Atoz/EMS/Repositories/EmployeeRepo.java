package com.Atoz.EMS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Atoz.EMS.Model.Entity.Employee;

public interface EmployeeRepo extends JpaRepository <Employee, Long>{
}
