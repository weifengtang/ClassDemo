package com.twf.class_28_jdbc_02.homeWork;

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:StudentDaoImpl
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2010:52
 * @Version:1.0 实现
 **/
public class StudentDaoImpl implements IStudentDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //    插入
    @Override
    public Integer insertStudent(Student student) {
        if (student == null) return 0; //TODO插入失败
        String insert_sql = "insert into student(studentName,Classid,Address,sex,Birthday) " +
                "values(?,?,?,?,?)";
        try {
            connection = JDBCUtils_02.getConnection();
            preparedStatement = connection.prepareStatement(insert_sql);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2, student.getClassid());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getSex());
            preparedStatement.setString(5, student.getBirthday());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_02.realse(null, preparedStatement, null);
        }
        return 0;
    }

    public static void main(String[] args) {
        StudentDaoImpl studentDao =  new StudentDaoImpl();
        Student select_student = new Student();
        select_student.setStudentName("李");
        ArrayList<Student> datas = (ArrayList<Student>) studentDao.selectStudent(select_student);
        System.out.println("查询结果："+datas);
    }

    //    更新
    @Override
    public Integer updateStudent(Student student) {

        if (student == null) return 0; //TODO更新失败
        //TODO 更新通用
        String update_sql = "update student set Address = ? where studentName = ? ";
        try {
            connection = JDBCUtils_02.getConnection();
            preparedStatement = connection.prepareStatement(update_sql);
            preparedStatement.setString(1, student.getAddress());
            preparedStatement.setString(2, student.getStudentName());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_02.realse(null, preparedStatement, null);
        }
        return 0;
    }

    //查询
    @Override
    public List<? extends Object> selectStudent(Student student) {
        if (student==null)
            student = new Student(); //查询条件studentName为空: 查所有记录

        List<Student> datas = new ArrayList();
        String selectSql = "select * from student where studentName like  ?";
        try {
            connection = JDBCUtils_02.getConnection();
            preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setString(1, "%" +student.getStudentName()+ "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                student.setStudentid((Integer) resultSet.getObject("studentid"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setClassid(resultSet.getInt("Classid"));
                student.setAddress(resultSet.getString("Address"));
                student.setSex(resultSet.getString("Sex"));
                student.setBirthday(resultSet.getString("Birthday"));
                datas.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_02.realse(null, preparedStatement, resultSet);
        }

        return datas;
    }

    //根据id删除学生
    @Override
    public Integer deleteStudent(Integer studentid) {
        String update_sql = "delete  from student where studentid =? ";
        try {
            connection = JDBCUtils_02.getConnection();
            preparedStatement = connection.prepareStatement(update_sql);
            preparedStatement.setInt(1, studentid);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_02.realse(null, preparedStatement, null);
        }
        return 0;
    }
}
