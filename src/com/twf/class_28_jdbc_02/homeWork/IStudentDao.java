package com.twf.class_28_jdbc_02.homeWork;

import java.util.List;

/**
 * 持久层接口
 */
public interface IStudentDao {

    //插入
    public abstract Integer insertStudent(Student student);
   //更新
    public abstract Integer updateStudent(Student student);
    //查询
    public abstract List<? extends  Object> selectStudent(Student student);
    //删除
    public abstract Integer deleteStudent(Integer studentid);

}
