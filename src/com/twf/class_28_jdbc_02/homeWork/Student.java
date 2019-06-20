package com.twf.class_28_jdbc_02.homeWork;

/**
 * @ClassName:Student
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2010:51
 * @Version:1.0
 **/
//学生类
public  class Student{
    private int studentid;
    private String studentName;
    private int Classid;
    private String Address;
    private String sex;
    private String Birthday;

    public Student() {
    }

    public Student(String studentName, int classid, String address, String sex, String birthday) {
        this.studentName = studentName;
        Classid = classid;
        Address = address;
        this.sex = sex;
        Birthday = birthday;
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