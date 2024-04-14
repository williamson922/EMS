package com.Atoz.EMS.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.Atoz.EMS.Model.Entity.Department;

public class DepartmentTest {

    @Test
    public void testDepartmentEntity() {
        Department department = new Department();
        department.setDepartmentName("HR");

        assertEquals("HR", department.getDepartmentName());

        department.setDepartmentName("Frontend");
        assertEquals("Frontend", department.getDepartmentName());
    }
}
