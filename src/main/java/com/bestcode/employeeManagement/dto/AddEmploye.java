package com.bestcode.employeeManagement.dto;

import com.bestcode.employeeManagement.Entity.Address;
import com.bestcode.employeeManagement.Entity.Department;
import com.bestcode.employeeManagement.Entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddEmploye {

    private Employee employee;
    private Address address;
    private Department department;

}
