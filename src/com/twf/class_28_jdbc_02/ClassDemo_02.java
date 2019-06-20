package com.twf.class_28_jdbc_02;

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName:HomeWork_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2016:19
 * @Version:1.0
 **/

/**
 *
 * 第二中批处理实现分析 •采用PreparedStatement.addBatch()实现批处理
 * • 优点：发送的是预编译后的SQL语句，执行效率高。
 * • 缺点：只能应用在SQL语句相同，但参数不同的批处理中。
 * 因此此 种形式的批处理经常用于在同一个表中批量插入数据，或批量更新表的数据。
 */
public class ClassDemo_02 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils_02.getConnection();
            String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 500000; i++) {
                preparedStatement.setString(1, "aaa" + i);
                preparedStatement.setString(2, "123" + i);
                preparedStatement.setString(3, "aaa" + i + "@sina.com");
                preparedStatement.setDate(4, new Date(1980, 10, 10));
                preparedStatement.addBatch();

                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();

            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_02.realse(connection,preparedStatement,null);
        }
    }
}
