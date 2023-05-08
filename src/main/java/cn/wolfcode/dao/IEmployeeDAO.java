package cn.wolfcode.dao;

import cn.wolfcode.domain.Employee;

import java.sql.SQLException;

public interface IEmployeeDAO {
    void insert(Employee employee) throws SQLException;
}
