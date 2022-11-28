package com.lam.employeespringapi.Model;


import com.lam.employeespringapi.validator.BlankConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    long id;
    String firstName;
    @BlankConstraint
    String lastName;
    @Email
    String email;
}
