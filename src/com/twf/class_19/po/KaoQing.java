package com.twf.class_19.po;

import java.io.Serializable;

/**
 * @ClassName:KaoQing
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/68:25
 * @Version:1.0
 **/
public class KaoQing implements Serializable {

    private int em_id;//员工ID,
    private int count;// 1出勤  0未出勤

    public KaoQing(int em_id, int count) {
        this.em_id = em_id;
        this.count = count;
    }

    public KaoQing() {

    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "KaoQing{" +
                "em_id=" + em_id +
                ", count=" + count +
                '}';
    }
}
