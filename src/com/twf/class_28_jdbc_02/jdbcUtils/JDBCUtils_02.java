package com.twf.class_28_jdbc_02.jdbcUtils;

import java.sql.*;

/**
 * @ClassName:JDBCUtils
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1915:58
 * @Version:1.0 JDBC工具类
 **/
public class JDBCUtils_02 {

    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Connection connection;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {
        Configuration configuration = Configuration.getInstance();
        DRIVER = configuration.getValue("jdbc_Driver");
        URL = configuration.getValue("jdbc_Url");
        USER = configuration.getValue("jdbc_User");
        PASSWORD = configuration.getValue("jdbc_PassWord");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //得到连接
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            threadLocal.set(connection);

        }
        return connection;

    }

    //设置手动开启事务
    public static void beginTranscation() throws SQLException {
        if(connection==null)
            getConnection();
        connection = threadLocal.get();
        connection.setAutoCommit(false);
        System.out.println("手动提交事务"+connection);

    }

    //设置提交事务
    public static void commitTransaction() throws SQLException {
        if(connection==null)
            getConnection();
        connection = threadLocal.get();
        connection.commit();
        System.out.println("提交事务"+connection);
    }

    //回滚事务
    public static void rollbackTransaction() throws SQLException {
        if(connection==null)
            getConnection();
        connection = threadLocal.get();
        System.out.println("回滚事务"+connection);
        connection.rollback();

    }

    //关闭
    public static void realse(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();

            if (statement != null)
                statement.close();

            if (connection != null) {
                connection.close();
                connection = null;
                threadLocal.remove();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
