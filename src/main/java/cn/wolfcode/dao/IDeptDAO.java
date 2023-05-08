package cn.wolfcode.dao;

import cn.wolfcode.domain.Dept;
import cn.wolfcode.domain.Employee;

import java.sql.SQLException;

public interface IDeptDAO {
    void insert(Dept dept) throws SQLException;
}
