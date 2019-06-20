package com.twf.class_27_jdbc;

import java.sql.*;

/**
 * @ClassName:JDBCUtils
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1915:58
 * @Version:1.0
 *
 * JDBC工具类
 **/
public class JDBCUtils {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localHost:3306/classdemo?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //得到连接
    public static Connection getConnection() {
        try {
            if (connection == null)
                return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void realse(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();

            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
