package com.ruge.test.mybatis.helloWorld.dao;

import com.ruge.test.mybatis.helloWorld.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    public boolean insertEmp(Employee employee);

    public boolean deleteEmp(Integer id);

    public boolean updateEmp(Employee employee);

    public List<Employee> selectEmp(Integer id);

}
