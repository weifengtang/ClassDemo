package com.twf.class_10;

public class Demo_05 {

	public static void main(String[] args) {
		int i = 80;
		
		/**
		 * 表达式数据类型不同，会向上转型
		 */
		String s = String.valueOf(i<100?90:100);
		
		String s1 = String.valueOf(i<100?90:100.0);
		
		String s2 = String.valueOf(i<100?'a':"cd");
		
		System.out.println(s2);
		// s:90	s1:90.0 
		//	两者是否相等：false
		System.out.println("s:"+s+"\ts1:"+s1+" \n两者是否相等："+s.equals(s1));
		
	}

}
