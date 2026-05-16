package com.employeeapp.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapp.empmanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
