package com.twf.class_20;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @ClassName:Demo_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1015:47
 * @Version:1.0
 * 完成多个List集合的以下运算
 * •1.并集(多个集合合并)
 * •2.交集(两个集合共同的元素)
 * •3.差集(属于集合1但不属于集合2的元素形成的集合)
 * •4.无重复的并集(两个集合合并后没有重复元素)
 *
 **/
public class Demo_01 {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(0);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println("list1--"+list1);
        System.out.println("list2--"+list2);

        //取并集
      /*  ListIterator listIterator = list2.listIterator();
        while (listIterator.hasNext()){
              list1.add(listIterator.next());
        }*/
        //取无重复的并集
        ListIterator listIterator = list2.listIterator();
        while (listIterator.hasNext()){
            Object object = listIterator.next();
            if (!list1.contains(object)){
                list1.add(object);
            }
        }
        //list1.retainAll(list2);//取两个集合中的交集
       // list1.removeAll(list2);//移除集合中在指定集合中所有相同的元素
        System.out.println("处理后-"+list1);
    }
}
