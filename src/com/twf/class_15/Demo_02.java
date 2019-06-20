package com.twf.class_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//枚举类
enum Week{Sun, Mon, Tue, Wed, Thu, Fri, Sat}

public class Demo_02 {

	/**
	 * asList的返回对象是一个Arrays静态私有内部类,并没有实现集合的修改方法。
	 * Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
	 * 只读，不能进行增删改操作；
	 * @param args
	 */
	public static void main(String[] args) {
		//五天工作制 
		Week[] workDays = {Week.Mon, Week.Tue, Week.Wed, Week.Thu, Week.Fri}; //转换为列表
		List<Week> list = Arrays.asList(workDays); //增加周六也为工作日
	//	list.add(Week.Sat); // UnsupportedOperationException
		list.set(list.size()-1,Week.Sat);
		System.out.println(list);
		System.out.println(list.size());
		System.out.print("\n解决办法：--------");
		
		list = new ArrayList<Week>(list);
		list.add(Week.Sat);
		System.out.println(list);
		
		System.out.println("----------\n\n");
		
		
		int data[] = {1,2,3,5,4};
		List<int[]> list2 = Arrays.asList(data);
		System.out.println(list2.get(0).getClass());
		System.out.println(list2.get(0).length);
		System.out.println(list2.size());
		
		
	}

}
