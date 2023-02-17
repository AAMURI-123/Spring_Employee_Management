package com.bestcode.employeeManagement.Service;

import com.bestcode.employeeManagement.Entity.Address;
import com.bestcode.employeeManagement.Entity.Employee;
import com.bestcode.employeeManagement.Repository.AddressRepository;
import com.bestcode.employeeManagement.Repository.EmployeeRepository;
import com.bestcode.employeeManagement.dto.AddEmploye;
import com.bestcode.employeeManagement.dto.EditEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           AddressRepository addressRepository){
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public String createEmployee(AddEmploye addEmploye) {

        String identificationNo =  UUID.randomUUID().toString().
                    replace("-","").substring(0,5);
        Employee employeeWithIdNoExist = employeeRepository.findByIdentificationNumber(identificationNo);
        if(employeeWithIdNoExist != null){
            identificationNo =  UUID.randomUUID().toString().
                    replace("-","").substring(0,5);
        }

        Employee employee = addEmploye.getEmployee();
        employee.setIdentificationNumber(identificationNo);
        Address address = addEmploye.getAddress();
        address.setEmployee(employee);
        employee.setDepartmentId(addEmploye.getDepartment());
        employee.setAddress(address);

        employeeRepository.save(employee);

        return identificationNo;
    }


    public void updateEmployee(EditEmployee editEmployee) {

        Date date = new Date();
    Optional<Employee> employeeFromDB = employeeRepository.findById(editEmployee.getEmployee().getId());

    if(employeeFromDB != null) {
        // edit the exist emp with a new employee info
        employeeFromDB.map(data -> {
            data = editEmployee.getEmployee();
            data.setUpdatedDate(date);
           data.setStartedDate(data.getStartedDate());
            data.setDepartmentId(editEmployee.getDepartment());

            return employeeRepository.save(data);
        });
    }
    else{
        throw  new IllegalStateException("Couldn't find data with the given Id");
    }
    }

    public void editAddress(Address address) {

        // getting the address we want to updated form DB and related employee.
        Optional<Address> addressFromDB = addressRepository.findById(address.getId());
        Optional<Employee> employeeFormDB = employeeRepository.findById(address.getId());

        addressFromDB.map(newAddress ->{
            newAddress = address;
            newAddress.setEmployee(employeeFormDB.get());
           return addressRepository.save(newAddress);
        });



    }
}
