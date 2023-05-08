package cn.wolfcode.service;

import cn.wolfcode.domain.Dept;
import cn.wolfcode.domain.Employee;

import java.sql.SQLException;

public interface IEmployeeService {
    void insert(Employee employee, Dept dept) throws SQLException;
}
