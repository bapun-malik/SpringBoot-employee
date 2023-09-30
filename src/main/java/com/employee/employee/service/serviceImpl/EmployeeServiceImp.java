package com.employee.employee.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.dto.EmployeeDto;
import com.employee.employee.model.Employee;
import com.employee.employee.repository.EmployeeRepo;
import com.employee.employee.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private ModelMapper mapper;

    public EmployeeServiceImp(EmployeeRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto emp) {
        Employee toSaveEmp = mapper.map(emp, Employee.class);
        Employee savedEmpl = repo.save(toSaveEmp);
        return mapper.map(savedEmpl, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto emp, Long id) {
        Employee e = repo.findById(id).get();
        if (e != null) {
            e.setFirstname(emp.getFirstname());
            e.setLastname(emp.getLastname());
            e.setEmail(emp.getEmail());
            e.setHavedl(emp.isHavedl());
            e.setDob(emp.getDob());
            repo.save(e);
        }
        return mapper.map(e, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployess() {
        List<Employee> empls = (List<Employee>) repo.findAll();
        List<EmployeeDto> allEmps = empls.stream()
                .map((emp) -> mapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
        return allEmps;
    }

    @Override
    public EmployeeDto findEmployee(Long id) {
        Employee emp = repo.findById(id).get();
        return mapper.map(emp, EmployeeDto.class);
    }

}
