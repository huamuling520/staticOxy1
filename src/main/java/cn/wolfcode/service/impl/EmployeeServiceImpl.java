package cn.wolfcode.service.impl;

import cn.wolfcode.dao.IDeptDAO;
import cn.wolfcode.dao.IEmployeeDAO;
import cn.wolfcode.domain.Dept;
import cn.wolfcode.domain.Employee;
import cn.wolfcode.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDAO employeeDAO;
    @Autowired
    private IDeptDAO deptDAO;

    /**
     *
     * @param employee 保存员工
     * @param dept 保存部门
     * @throws SQLException
     */
    @Override
    public void insert(Employee employee, Dept dept) throws SQLException {
        employeeDAO.insert(employee);
        deptDAO.insert(dept);
    }
}
