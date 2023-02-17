package com.bestcode.employeeManagement.Repository;

import com.bestcode.employeeManagement.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
@CrossOrigin("http://localhost:4200")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByFirstName(@RequestParam("firstName") String firstName,
                                             Pageable pageable);
    Employee findByIdentificationNumber(@RequestParam("identificationNumber") String identificationNumber);
}
