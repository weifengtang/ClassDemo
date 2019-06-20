package com.twf.class_27_jdbc;

import java.sql.*;
import java.util.Random;

/**
 * @ClassName:JDBC_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1914:25
 * @Version:1.0
 **/
public class JDBC_01 {
//        final int a = new Random().nextInt(44);
//        static int b = new Random().nextInt(44);
//        static final int c=new Random().nextInt(44);
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        JDBC_01 jdbc_01 = new JDBC_01();
//        System.out.print("a=" + jdbc_01.a);
//
//        System.out.print("b=" + jdbc_01.b);
//        b = 10;
//        System.out.print("b=" + jdbc_01.b);
//
//        System.out.println("c=" + jdbc_01.c);
//
//        JDBC_01 jdbc_02 = new JDBC_01();
//        System.out.print("a=" + jdbc_02.a);
//        System.out.print("b=" + jdbc_02.b);
//        System.out.println("c=" + jdbc_02.c);



        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/classdemo?useUnicode=true&characterEncoding=utf-8",
                "root","root");
        System.out.println(con);

        String sql = "select * from student ";
        String sql2 = "select Ssno from student batch";
        String sql3 = "select Sage from student batch";
        Statement statement = con.createStatement();
        System.out.println(statement);//Statement接口的实现类
        //PreparedStatement extends Statement
        statement.execute("show tables");//任意语句
       // statement.executeUpdate("增删改语句");
       // ResultSet rs =  statement.executeQuery(sql);//查询语句
        //System.out.println(rs);
//        while(rs.next()){
//            System.out.print(rs.getObject("studentid"));
//            System.out.print(rs.getObject(2));
//            System.out.print(rs.getObject(3));
//            System.out.print(rs.getObject(4));
//            System.out.print(rs.getObject(5));
//            System.out.println(rs.getObject(6));
//        }
        statement.close();
        con.close();
    }
}
