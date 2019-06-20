package com.twf.class_28_jdbc_02.homeWork;

import java.util.ArrayList;

/**
 * @ClassName:HomeWork_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2010:48
 * @Version:1.0
 **/
public class HomeWork {
    public static void main(String[] args) {

        //代理主题
        IStudentDao iStudentDao = (IStudentDao) new MyHandler().newProxyInstance(new StudentDaoImpl());
        int result = 0;

        //插入学生信息
        Student insert_Studnet = new Student("baby",
                2,"中国","女","2019-6-20");
        result = iStudentDao.insertStudent(insert_Studnet);
        System.out.println("更新结果："+result);

        //更新学生信息
        Student update_Studnet = new Student();
        update_Studnet.setStudentName("baby");
        update_Studnet.setAddress("中国_更新后的数据");
        result = iStudentDao.updateStudent(update_Studnet);
        System.out.println("更新结果："+result);

        //删除学生
        result = iStudentDao.deleteStudent(79);
        System.out.println("删除结果："+result);


        //查询学生
        Student select_student = new Student();
        select_student.setStudentName("李");
        ArrayList<Student> datas = (ArrayList<Student>) iStudentDao.selectStudent(select_student);
        System.out.println("查询结果："+datas);



    }
}
