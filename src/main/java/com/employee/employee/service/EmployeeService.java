package com.employee.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.employee.dto.EmployeeDto;
@Service
public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto emp);
    public EmployeeDto findEmployee(Long id);
    public List<EmployeeDto> getAllEmployess();
    public EmployeeDto updateEmployee(EmployeeDto emp,Long id);
    public void deleteEmployee(Long id);
}
