package com.twf.class_15.beanFactory;

import com.twf.class_10.Demo_09;
import com.twf.class_13.Demo1;

/**
 * @ClassName:Test
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/110:43
 * @Version:1.0
 **/
public class Test {

    public static void main(String[] args) {

        IShow show = (IShow) BeanFactory.getBean(new ShowMemoey());
        String  s = show.showSize()+" kB";
        System.out.println(s);
        int i =1;

       while (true){

           System.out.print(++i);
           if(i>100)
               break;
       }
        String  s2 = show.showSize()+" kB";
        System.out.println(s);
    }
}
