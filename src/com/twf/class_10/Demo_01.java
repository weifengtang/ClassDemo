package com.twf.class_10;

import java.util.HashMap;

public class Demo_01 {
	//static Scanner input ;
	//static int age = 0;
	
	/**1、if else方式：边界值的控制
	 * 2、数组方式
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		 //input  =  new Scanner(System.in);
		long start1 = System.nanoTime();
		for (int i = 1; i <= 150; i++) {
			fun1(i);			
		}
		Long end1 = System.nanoTime();
		
		
		System.out.println();
		long start2 = System.nanoTime();
		for (int i = 1; i <= 150; i++) {
			fun2(i);			
		}
		System.out.println("耗时1   "+(end1-start1));
		System.out.println("耗时2   "+(System.nanoTime()-start2));
	
		 
	}	
	//集合mapd饿方式
	private static void fun3(int age) {
		HashMap<Integer,String> ages = new HashMap<Integer, String>();
		ages.put(0,"少年");
		ages.put(1,"青年");
		ages.put(2,"中年");
		ages.put(3,"老年");
		//String ages[] = {"少年","青年","中年","老年"};
		int c = age/20;
		if(c>=3) {
			c=3;	
		}
		System.out.println("年龄："+age+"--"+ages.get(c));	
	}
	
	
	private static void fun2(int age) {
		/*
		 * ArrayList<String> ages = new ArrayList<String>(); ages.add("少年");
		 * ages.add("青年"); ages.add("中年"); ages.add("老年");
		 */
		 String ages[] = {"少年","青年","中年","老年"};
		int c = age/20;
		if(c>=3) {
			c=3;	
		}
		System.out.println("年龄："+age+"--"+ages[c]);			
		
	}

	//if else方式
	private static void fun1(int age) {
		//System.out.println("输入年龄（1——150之间的数字）：");
		 //getScanner();
		 if(age>=60) {
			 System.out.println("年龄："+age+">60——老年");
		 }else if(age>=40){
			 System.out.println("年龄:  "+age+">40——中年");
		 }else if(age>=20) {
			 System.out.println("年龄 :  "+age+">20——青年");
		 }else {
			System.out.println("年龄:  "+age+"<20——少年");
		}
	}
	
	/*
	 * public static void getScanner() { try{ age = Integer.parseInt(input.next());
	 * if(age<0||age>150) { throw new NumberFormatException(); } }catch
	 * (NumberFormatException e) { System.out.println("请输入1——150之间的数字");
	 * getScanner(); } }
	 */

}
