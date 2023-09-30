package com.employee.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.employee.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Long>{
        
}
