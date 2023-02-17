package com.bestcode.employeeManagement.dto;

import com.bestcode.employeeManagement.Entity.Department;
import com.bestcode.employeeManagement.Entity.Employee;
import lombok.Data;

@Data
public class EditEmployee {

    private Employee employee;
    private Department department;
}
