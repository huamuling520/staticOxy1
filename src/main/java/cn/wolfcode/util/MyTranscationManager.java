package cn.wolfcode.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 自定义事务管理器
 */
@Repository
public class MyTranscationManager {
    @Autowired
    private DataSource dataSource;

    //保存连接的变量,防止多次连接时连接对象改变
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    //获取连接,两个到都需要使用同一个connection,保存连接的变量
    public Connection getConnection(){
        Connection conn = threadLocal.get();
        if(conn==null){
            try {
                conn = dataSource.getConnection();
                //将连接设置到threadlocal
                threadLocal.set(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }
    //手动开启事务
    public void startTx(){
        Connection connection = getConnection();
        System.out.println("startTx"+connection);
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //提交事务
    public void  commit(){
        try {
            getConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //回滚事务
    public void rollback(){
        try {
            getConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //关闭连接

    public void close() {
        try {
            getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
