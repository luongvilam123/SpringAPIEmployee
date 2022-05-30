package com.lam.employeespringapi.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity // danh dau la entity
@Data
@Table(name = "employees")  // ten table se dc tao boi hibernate trong database
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
