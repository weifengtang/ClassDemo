package com.twf.class_27_jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:HomeWork_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1915:57
 * @Version:1.0 MySQL分页的实现：
 * •Select * from table limit M,N
 * •M：记录开始索引位置 •N：取多少条记录。
 **/
public class HomeWork_01 {
    private static Connection connection = JDBCUtils.getConnection();

    public static void main(String[] args) {
        HomeWork_01  homeWork_01 = new HomeWork_01();

        ArrayList<Student> datas = (ArrayList<Student>) homeWork_01.getDatas("student",1,5);

        System.out.println(datas);
        System.out.println(datas.size());

        String sql_2 = "select count(studentid) from student ";
        int a  = homeWork_01.getSize(sql_2);
        System.out.println(a);

        JDBCUtils.realse(connection,null,null);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        String dateTime = simpleDateFormat.format(new  Date());

        Date date = new Date();

    }


    //分页数据
    public List<Student> getDatas(String table,int start,int end){
       // String sql = "select * from  "+table+"  limit  "+start+" , "+end+"";
        String sql = "select * from "+table+" limit ?,?";
        List<Student> datas = new ArrayList<Student>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1,table);
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,end);
            System.out.println(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
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
            JDBCUtils.realse(null,preparedStatement,resultSet);
        }
        return  datas;
    }
    //总记录数
    public Integer getSize(String sql) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
          return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.realse(null,preparedStatement,resultSet);
        }

        return 1;
    }

}

//学生类
class Student{
    private int studentid;
    private String studentName;
    private int Classid;
    private String Address;
    private String sex;
    private String Birthday;

    public Student() {
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getClassid() {
        return Classid;
    }

    public void setClassid(int classid) {
        Classid = classid;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", studentName='" + studentName + '\'' +
                ", Classid=" + Classid +
                ", Address='" + Address + '\'' +
                ", sex='" + sex + '\'' +
                ", Birthday='" + Birthday + '\'' +
                '}';
    }
}