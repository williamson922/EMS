package com.Atoz.EMS.Model.DTO;

import java.util.Set;

public class ProjectDTO {
private Long id;
private String projectName;
private Set<Long> employeeIds;
public ProjectDTO() {
}
public ProjectDTO(Long id, String projectName, Set<Long> employeeIds) {
    this.id = id;
    this.projectName = projectName;
    this.employeeIds = employeeIds;
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
public Set<Long> getEmployeeIds() {
    return employeeIds;
}
public void setEmployeeIds(Set<Long> employeeIds) {
    this.employeeIds = employeeIds;
}


}
