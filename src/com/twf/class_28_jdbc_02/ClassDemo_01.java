package com.twf.class_28_jdbc_02;

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName:ClassDemo_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/208:47
 * @Version:1.0
 **/
public class ClassDemo_01 {

    /**
     * 批量操作方式一：Statement
     * 第一种批处理实现的优缺点
     * •采用Statement.addBatch(sql)方式实现批处理：
     * • 优点：可以向数据库发送多条不同的ＳＱＬ语句。
     * • 缺点：
     * • SQL语句没有预编译。
     * • 当向数据库发送多条语句相同，但仅参数不同的SQL语句时，需重复写上 很多条SQL语句。
     * • 例如：
     * Insert into user(name,password) values(‘aa’,’111’);
     * Insert into user(name,password) values(‘bb’,’222’);
     * Insert into user(name,password) values(‘cc’,’333’);
     * Insert into user(name,password) values(‘dd’,’444’);
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "Drop table if exists tt";
        String sql_01 = "create table tt(id int primary key auto_increment" +
                ",name varchar(40),passWord varchar(40))";
        String sql_02 = "insert into tt(name,passWord) values('刘星光','123456')";
        String sql_03 = "update tt set name='唐伟锋' where passWord = '123456'";

        try {
            connection = JDBCUtils_02.getConnection();
            statement = connection.createStatement();
            statement.addBatch(sql);//把SQL语句加入到批命令中
            statement.addBatch(sql_01);
            statement.addBatch(sql_02);
            statement.addBatch(sql_03);
           int result[] =  statement.executeBatch();
            statement.clearBatch();
            for (int i = 0; i <result.length ; i++) {
                System.out.println(result[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_02.realse(connection,statement,null);
        }

    }

}
