package com.twf.class_19.po;

import java.io.Serializable;

/**
 * @ClassName:Emplo
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/68:24
 * @Version:1.0
 * 员工
 **/
public class Emplo implements Serializable {

    private int em_id;//员工ID
    private String em_name;//员工姓名

    //...

    public Emplo(int em_id, String em_name) {
        this.em_id = em_id;
        this.em_name = em_name;
    }

    public Emplo() {
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public String getEm_name() {
        return em_name;
    }

    public void setEm_name(String em_name) {
        this.em_name = em_name;
    }

    @Override
    public String toString() {
        return "Emplo{" +
                "em_id=" + em_id +
                ", em_name='" + em_name + '\'' +
                '}';
    }
}
