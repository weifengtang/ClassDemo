package com.twf.class_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @ClassName:Demo_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1017:07
 * @Version:1.0
 *
 * 使用List集合存储10个1-50(含50)的随机偶数元素,
 * 要求数字不能重复,添加完成后从大到小倒序遍历输 出到控制台并使用IO流将集合中的元素按指定格式
 * 输出到当前项目的num.txt中,例如: 48,44,40,38,34,30,26......
 **/
public class Demo_03 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);
        int count = 0;
        while (count<10){
            int number = (new Random().nextInt(50)+1);
            if((number&1)==0){//偶数
                arrayList.add(number);
                count++;
            }
        }

        Collections.sort(arrayList); //升序排序
        System.out.println(arrayList);

        Collections.reverse(arrayList); //反转列表顺序
        System.out.println(arrayList);
        //TODO 利用IO输出到文本
    }
}
