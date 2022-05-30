package com.lam.employeespringapi.Controller;


import com.lam.employeespringapi.Model.Employee;
import com.lam.employeespringapi.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins ="http://localhost:3000" )
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {

        this.employeeServices = employeeServices;
    }
     @PostMapping("/employees")
    public Employee createEmployee( @RequestBody Employee employee){
        return employeeServices.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeServices.getAllEmployees();

    }
}
