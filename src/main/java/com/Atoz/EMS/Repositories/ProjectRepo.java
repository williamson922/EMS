package com.Atoz.EMS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Atoz.EMS.Model.Entity.Project; 

public interface ProjectRepo extends JpaRepository<Project,Long> {

}
