package cn.wolfcode.dao.impl;

import cn.wolfcode.dao.IDeptDAO;
import cn.wolfcode.dao.IEmployeeDAO;
import cn.wolfcode.domain.Dept;
import cn.wolfcode.domain.Employee;
import cn.wolfcode.util.MyTranscationManager;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DeptMapperImpl implements IDeptDAO {
    @Autowired
    private MyTranscationManager myTranscationManager;
    @Override
    public void insert(Dept dept) throws SQLException {

        Connection connection = myTranscationManager.getConnection();
        System.out.println("dept:" + connection);
        @Cleanup
        PreparedStatement ps = connection.prepareStatement("insert into dept (dept_id,dept_name) values(?,?)");
        ps.setInt(1,dept.getId());
        ps.setString(2,dept.getName());
        ps.executeUpdate();
    }
}
