package cn.wolfcode.service.impl;


import cn.wolfcode.domain.Dept;
import cn.wolfcode.domain.Employee;
import cn.wolfcode.service.IEmployeeService;
import cn.wolfcode.util.MyTranscationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * 这个类是EmployeeServiceImpl的代理类
 * 需要对insert方法进行事务的增强,实现同一个接口方便管理
 */
@Service
public class EmployeeServiceImplOxy implements IEmployeeService {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private MyTranscationManager myTranscationManager;

    @Override
    public void insert(Employee employee, Dept dept) {
        try {
            myTranscationManager.startTx();
            employeeService.insert(employee,dept);
            myTranscationManager.commit();
        } catch (SQLException throwables) {
            myTranscationManager.rollback();
            throwables.printStackTrace();
        } finally {
            myTranscationManager.close();
        }
    }
}
