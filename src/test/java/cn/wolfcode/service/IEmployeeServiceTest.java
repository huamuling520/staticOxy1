package cn.wolfcode.service;

import cn.wolfcode.domain.Dept;
import cn.wolfcode.domain.Employee;
import cn.wolfcode.service.impl.EmployeeServiceImplOxy;
import cn.wolfcode.util.MyTranscationManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springconfig.xml")
public class IEmployeeServiceTest {
    @Autowired
    private EmployeeServiceImplOxy employeeServiceImplOxy;
    @Autowired
    private MyTranscationManager myTranscationManager;

    @Test
    public void insert() {
        //创建部门
        Dept dept = new Dept();
        dept.setName("销售部");
        dept.setId(1);
        //创建员工
        Employee e = new Employee();
        e.setName("小雪");
        e.setSn("女");
        e.setSalary(new BigDecimal(4500));
        e.setDept_id(dept.getId());
         employeeServiceImplOxy.insert(e,dept);
    }
}