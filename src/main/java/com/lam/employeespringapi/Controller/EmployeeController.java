package com.lam.employeespringapi.Controller;


import com.lam.employeespringapi.Entity.EmployeeEntity;
import com.lam.employeespringapi.Model.Employee;
import com.lam.employeespringapi.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {

        this.employeeServices = employeeServices;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeServices.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeServices.getAllEmployees();

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
        deleted = employeeServices.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable Long id){
        Employee employee =new Employee();
        employee=employeeServices.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee =employeeServices.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);

    }
}
