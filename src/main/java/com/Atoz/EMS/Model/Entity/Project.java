package com.Atoz.EMS.Model.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private Long employeeId;

    @ManyToMany
    @JoinTable(name = "employee_project", joinColumns = {
            @JoinColumn(name = "project_id") }, inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees = new HashSet<>();

    public Project(Long id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
