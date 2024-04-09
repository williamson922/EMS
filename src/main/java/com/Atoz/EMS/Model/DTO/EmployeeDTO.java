package com.Atoz.EMS.Model.DTO;

import java.util.Set;

public class EmployeeDTO {
private Long id;
private String name;
private String position;
private Long departmentId;
private Set<Long> projectIds;


public EmployeeDTO() {
}

public EmployeeDTO(Long id, String name, String position,Long departmentId) {
    this.id = id;
    this.name = name;
    this.position = position;
    this.departmentId = departmentId;

}

public EmployeeDTO(Long id, String name, String position, Long departmentId, Set<Long> projectIds) {
    this.id = id;
    this.name = name;
    this.position = position;
    this.departmentId = departmentId;
    this.projectIds = projectIds;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getPosition() {
    return position;
}

public void setPosition(String position) {
    this.position = position;
}
public Long getDepartmentId() {
    return departmentId;
}

public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
}

public Set<Long> getProjectIds() {
    return projectIds;
}

public void setProjectIds(Set<Long> projectIds) {
    this.projectIds = projectIds;
}


}
