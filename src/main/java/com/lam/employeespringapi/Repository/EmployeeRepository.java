package com.lam.employeespringapi.Repository;

import com.lam.employeespringapi.Entity.EmployeeEntity;
import com.lam.employeespringapi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
