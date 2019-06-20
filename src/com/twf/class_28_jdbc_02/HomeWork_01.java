package com.twf.class_28_jdbc_02;

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.sql.*;

/**
 * @ClassName:HomeWork_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2010:10
 * @Version:1.0
 **/
public class HomeWork_01 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        String insert_sql = "insert into student(studentName,Classid,Address,sex,Birthday) " +
                "values('baby',2,'中国','男','2019-6-20')";
        String update_sql = "update student set Address = '中国大陆' where studentName = ? ";
        String select_sql = "select * from student where studentName like ? ";
        try {
            connection = JDBCUtils_02.getConnection();
          /*  //插入
            preparedStatement = connection.prepareStatement(insert_sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            int re = preparedStatement.executeUpdate();
            System.out.println("执行结果： "+re);

            resultSet =  preparedStatement.getGeneratedKeys();
            int key = 1;
            while (resultSet.next()){
                key =  resultSet.getInt(1);//得到插入行主键
            }*/

            //更新
         /*   preparedStatement = connection.prepareStatement(update_sql);
            preparedStatement.setString(1,"唐僧2" );
            int ra = preparedStatement.executeUpdate();
            System.out.println("执行结果： "+ra);*/

//         模糊查询
            preparedStatement = connection.prepareStatement(select_sql);
            preparedStatement.setString(1,"%李%" );
            resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("执行结果： "+resultSet.getObject(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_02.realse(connection, preparedStatement, resultSet);
        }
    }
}
