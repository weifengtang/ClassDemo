package com.twf.class_23;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:Demo_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1410:50
 * @Version:1.0
 **/
public class Demo_02 {


    //最大连续子序列和----动态规划
    public static int maxSub1(List<Integer> list){
        int ThisSum,MaxSum,j;
        ThisSum = MaxSum =0;
        for(j = 0;j < list.size();j++)
        {
            ThisSum += list.get(j);

            if(ThisSum > MaxSum)
                MaxSum = ThisSum;
            else if(ThisSum < 0)
                ThisSum = 0;
        }
        return MaxSum;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(6);
        System.out.println(list.size());
        list.add(6);
        list.add(22);
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(0);
        int MaxSum = maxSub1(list);
        System.out.println(MaxSum);

        //ArrayList集合中的 indexOf方法
        Object elementData[]  ={22,"aa","aa",232,null};
        int index  = indexOf(null,elementData);
        //int index  = indexOf(232,elementData);
        System.out.println("ArrayList集合中的 indexOf方法:"+index);
    }


    //集合中的 indexOf方法
    public static int indexOf(Object o,Object elementData[]) {
        int size = elementData.length;
        if (o == null) { //indexOf(null,elementData);
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
}
