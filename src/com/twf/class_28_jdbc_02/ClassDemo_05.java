package com.twf.class_28_jdbc_02;

/**
 * @ClassName:ClassDemo_05
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2017:08
 * @Version:1.0
 **/

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * ResultSetMetaData
 * •使用ResultSetMetaData可获取关于ResultSet对象中
 *          列 的类型和属性信息的对象,
 * ResultSetMetaData存储了ResultSet的 MetaData,可以通过以下的方法取得一些 ResultSet的信息。
 */
public class ClassDemo_05 {
    public static void main(String[] args) throws SQLException {
        ResultSetMetaData rsmd = null; // 结果集元数据
        PreparedStatement pstmt = null; // 数据库操作对象

        Connection conn = JDBCUtils_02.getConnection();
        String sql = "SELECT studentid,studentName,Classid,Address,sex,Birthday FROM student;";
        pstmt = conn.prepareStatement(sql); // 实例化对象
        rsmd = pstmt.getMetaData(); // 得到结果集元数据

        System.out.println(""+rsmd.getTableName(1));

        int columnCount = rsmd.getColumnCount();
        System.out.println("返回此 ResultSet 对象中的列数。  " + columnCount + "列数据。");
        System.out.println("列名称: "+ "\t 列类型(DB): "+"\t长度: "+"\t是否自动编号: "+"\t是否可以为空: "+ "\t是否可以写入: ");
        for (int i = 1; i < columnCount ; i++) {
            System.out.print(rsmd.getColumnName(i)+"\t\t"); //列名称
            System.out.print( rsmd.getColumnTypeName(i)+"\t\t"); //列类型
            System.out.print(rsmd.getPrecision(i)+"\t\t");
            System.out.print( rsmd.isAutoIncrement(i)+"\t\t");
            System.out.print( rsmd.isNullable(i)+"\t\t");
            System.out.print( rsmd.isReadOnly(i)+"\t\t");
            System.out.println();
        }
        pstmt.close();
        conn.close();
    }
}
