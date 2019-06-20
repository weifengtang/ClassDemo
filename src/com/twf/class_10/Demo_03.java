package com.twf.class_10;

public class Demo_03 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			//先把count赋值给一个中间变量，这个中间变量+1;在把count赋值给等号左边
			//而++count;把count+1；赋值给左边；
			//count = ++count;
			count = count++; 
		}
		System.out.println("count = "+count);
		
	}

}
