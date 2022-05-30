package com.lam.employeespringapi.Services;


import com.lam.employeespringapi.Entity.EmployeeEntity;
import com.lam.employeespringapi.Model.Employee;
import com.lam.employeespringapi.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeServices{

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
        List<Employee> employees= employeeEntities.stream()
                .map(emp-> new Employee(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail()))
                .collect(Collectors.toList());
        return employees;
    }
}
