package com.ruge.test.springMVC.RESTFulCRUD;

import java.util.Date;

import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    //1 male, 0 female
    private Integer gender;
    private Department department;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @NumberFormat(pattern = "#,###,###.#")
    private Float salary;
}
