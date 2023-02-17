package com.bestcode.employeeManagement.Repository;

import com.bestcode.employeeManagement.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@CrossOrigin
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findById(@RequestParam("id") Long id);
}
