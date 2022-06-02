package com.lam.employeespringapi.Services;

import com.lam.employeespringapi.Model.Employee;

import java.util.List;

public interface EmployeeServices {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);
}
