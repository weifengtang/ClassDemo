package com.twf.class_28_jdbc_02;

/**
 * @ClassName:ClassDemo_04
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2016:54
 * @Version:1.0
 **/

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 元数据类 DatabaseMetaData
 * •DatabaseMetaData可以得到数据库的一些基本信息,包括数据 库的名称、版本,以及得到表的信息。
 */
public class ClassDemo_04 {

    public static void main(String[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        DatabaseMetaData databaseMetaData = null;

        try {
            connection = JDBCUtils_02.getConnection();
            databaseMetaData = connection.getMetaData(); // 实例化元数据
            System.out.println("数据库名称：" + databaseMetaData.getDatabaseProductName());
            System.out.println("数据库版本：" + databaseMetaData.getDriverMajorVersion() + "." + databaseMetaData.getDatabaseMinorVersion());

/**
 * 获取指定的数据库的所有表的类型,getTables()的第一个参数就是数据库名
 * 因为与MySQL连接时没有指定,这里加上,剩下的参数就可以为null了
 * 第二个参数是模式名称的模式,但是输出也是什么都没有。谁知道告诉我一声
 */
            System.out.println("获取指定的数据库的所有表的类型");
            ResultSet rs1 = databaseMetaData.getTables("classdemo", null, null, null);

            while (rs1.next()) {
                System.out.println();
                System.out.println("数据库名:" + rs1.getString(1));
                System.out.println("表模式：" + rs1.getString(2));
                System.out.println("表名: " + rs1.getString(3));
                System.out.println("类型: " + rs1.getString(4));
            }
            rs1.close();
            System.out.println("\n");

            System.out.println("获取指定的数据库的表的主键");
            //获取指定的数据库的表的主键，第二个参数也是模式名称的模式,使用null了
            resultSet = databaseMetaData.getPrimaryKeys("classdemo", null, "student");//得到指定表的主键
            while (resultSet.next()) {
                System.out.println("数据库名: " + resultSet.getString(1));
                System.out.println("表模式：" + resultSet.getString(2));
                System.out.println("表名称：" + resultSet.getString(3));
                System.out.println("列名称：" + resultSet.getString(4));
                System.out.println("主键序列号" + resultSet.getString(5));
                System.out.println("主键名称" + resultSet.getString(6));
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
