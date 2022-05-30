package com.lam.employeespringapi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    long id;
    String firstName;
    String lastName;
    String email;
}
