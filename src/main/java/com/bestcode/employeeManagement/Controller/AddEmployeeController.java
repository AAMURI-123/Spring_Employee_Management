package com.bestcode.employeeManagement.Controller;

import com.bestcode.employeeManagement.Entity.Address;
import com.bestcode.employeeManagement.Entity.Employee;
import com.bestcode.employeeManagement.Repository.EmployeeRepository;
import com.bestcode.employeeManagement.Service.EmployeeService;
import com.bestcode.employeeManagement.dto.AddEmploye;
import com.bestcode.employeeManagement.dto.EditEmployee;
import com.bestcode.employeeManagement.dto.SaveEmployee;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class AddEmployeeController {

    private EmployeeService employeeService;
    private SaveEmployee saveEmployee;

    @Autowired
public AddEmployeeController(EmployeeService employeeService,
                             SaveEmployee saveEmployee){
    this.employeeService = employeeService;
    this.saveEmployee = saveEmployee;
}

    @PostMapping(path = "/employee/register")
    public SaveEmployee addNewEmployee(@RequestBody AddEmploye addEmploye){

        saveEmployee.setIdentification(employeeService.createEmployee(addEmploye));
        return saveEmployee;
        //new JSONParser(employeeService.createEmployee(addEmploye);
    }

    @PutMapping(path = "/employee/edit")
    public void editEmployee(@RequestBody EditEmployee editEmployee){

        employeeService.updateEmployee(editEmployee);
    }

    @PutMapping(path = "/address/edit")
    public void updateAddress(@RequestBody Address address){

        employeeService.editAddress(address);
    }
}
