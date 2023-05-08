package cn.wolfcode.dao.impl;

import cn.wolfcode.dao.IEmployeeDAO;
import cn.wolfcode.domain.Employee;
import cn.wolfcode.util.MyTranscationManager;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class EmployeeMapperImpl implements IEmployeeDAO {
    @Autowired
    private MyTranscationManager myTranscationManager;

    @Override
    public void insert(Employee employee) throws SQLException {
        Connection connection = myTranscationManager.getConnection();
        System.out.println("employee:" + connection);
        @Cleanup
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO employee (name,sn,salary,dept_id) values(?,?,?,?)");
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getSn());
        ps.setBigDecimal(3, employee.getSalary());
        ps.setInt(4, employee.getDept_id());
        ps.executeUpdate();
    }
}
