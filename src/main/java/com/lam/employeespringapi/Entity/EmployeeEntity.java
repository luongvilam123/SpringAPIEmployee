package com.lam.employeespringapi.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // danh dau la entity
@Data
@Builder
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
// ten table se dc tao boi hibernate trong database
public class EmployeeEntity {

    @Id   // chon id lam khoa chinh bang cach de anotaion truoc id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //rang buoc dinh danh khoa chinh
    long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;
}
