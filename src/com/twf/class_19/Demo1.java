package com.twf.class_19;

import com.twf.class_19.po.Emplo;
import com.twf.class_19.po.KaoQing;

import java.util.*;

/**
 * @ClassName:Demo1
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/68:19
 * @Version:1.0 有一组员工名单, 有一组考勤数据
 * 从产生的考勤数据中找出未出勤的员工名单
 **/
public class Demo1 {

   private HashMap<Integer,String> emplos;
   private HashMap<Integer,Integer>  kqs;
   private ArrayList<Integer> noKqs ;

    public Demo1() {
        init();
    }

    /**
     * 员工名单：员工ID,员工姓名
     * <p>
     * 考勤数据：员工ID,缺勤 1出勤  0未出勤
     */

    public void init() {
        noKqs = new ArrayList<Integer>();
        emplos = new HashMap<Integer,String>();
        emplos.put(1, "张三");
        emplos.put(2, "李四");
        emplos.put(3, "王五");
        emplos.put(4, "二麻子");
        kqs = new  HashMap<Integer,Integer>();
        kqs.put(1, 1);
        kqs.put(2, 0);
        kqs.put(3, 0);
        kqs.put(4, 1);
    }

    public void sort(){
       Set<Integer> set =  kqs.keySet();
      //得到未考勤人员 id
       for (int key:set) {
            int value = kqs.get(key);
            if(value==0){
                noKqs.add(key);
            }
        }
        for (int i = 0; i <noKqs.size() ; i++) {
            System.out.println("未出勤人员："+emplos.get(noKqs.get(i)));
        }


    }

    public static void main(String[] args) {
        Demo1 d = new Demo1();
        d.sort();
    }

}
