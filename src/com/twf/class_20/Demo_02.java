package com.twf.class_20;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

/**
 * @ClassName:Demo_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1016:17
 * @Version:1.0 •将两个集合{“a”，“b”，“c”，“d”，“e”}
 * •和{“d”，“e”，“f”，“g”，“h”},
 * 把这两 个集合去除重复项合并成一个,实现需求
 * <p>
 * •扩展:通过随机生成1000个随机组合的2-8个字母,
 * 然后通过集合快速找到重复超过3次以上的字母组 合,并放在新集合中输出。
 **/
public class Demo_02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("h");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("d");
        arrayList2.add("e");
        arrayList2.add("f");
        arrayList2.add("c");
        arrayList2.add("h");
        //fun1(arrayList, arrayList2);
        ArrayList arrayList3 = new ArrayList(1000);

        //随机字母
        getRandomWord(arrayList, arrayList3);
        System.out.println(arrayList3);
        System.out.println(arrayList3.size());

        ArrayList arrayList4 = new ArrayList();

        ListIterator listIterator = arrayList3.listIterator();
        int length = arrayList3.size();
        Object object = null;
        int count = 0;
        for (int i = 0; i < length; i++) {
            object = arrayList3.get(i); //取一个数
            for (int j = 0; j < length; j++) {//遍历集合
                Object o = arrayList3.get(j);
                if (o.equals(object)) {
                    count++;
                }
            }
            if (count >= 5) {
                arrayList4.add(object);
            }
            count = 0;
        }

        System.out.println("出现三次以上的集合："+arrayList4);
        System.out.println("出现三次以上的个数："+arrayList4.size());


    }

    //得到随机字母
    private static void getRandomWord(ArrayList arrayList, ArrayList arrayList3) {
        int length = arrayList.size();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < 1000) {
            int number = new Random().nextInt(length) + 2;//随机 循环次数2-8 //(int) ((Math.random() * 10) % 29 + 1);
            int count = 0;
            while (count < number) {
                int index = new Random().nextInt(length);//0-length中生成随机int数 (随机字母)
                sb.append(arrayList.get(index));
                count++;
            }
            arrayList3.add(sb.toString());//添加元素
            sb.delete(0, sb.length());
            i++;
        }

    }

    //两 个集合去除重复项合并成一个
    private static void fun1(ArrayList arrayList, ArrayList arrayList2) {
        //取无重复的并集
        ListIterator listIterator = arrayList2.listIterator();
        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            if (!arrayList.contains(object)) {
                arrayList.add(object);
            }
        }
        System.out.println(arrayList);
    }
}
