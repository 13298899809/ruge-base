package com.ruge.test.mybatis.Mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="tabple_emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empId;//emp_id
	
	private String empName;//emp_name
	
	@Column(name="emp_salary")
	private Double empSalary;//emp_salary_apple
	
	private Integer empAge;//emp_age
}
