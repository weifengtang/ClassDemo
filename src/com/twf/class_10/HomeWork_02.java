package com.twf.class_10;

/**
 * 
 * 字符串拼接有三种方式 //加号拼接 str+="c"；
 *  //concat方法连接 str=str.concat("c"); 
 *  new StringBuilder("a").append("c");
要求: 分别记录三种拼接10W次的时间和内存消耗 分析出三种拼接底层原因
 * @author TWF
 *
 */
public class HomeWork_02 {

	public static void main(String[] args) {
		HomeWork_02 homeWork_02 = new HomeWork_02();
		new Thread(new Runnable() {
			public void run() {
				homeWork_02.addString(100000);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				homeWork_02.concatString(100000);
			}
		}).start();
		
		homeWork_02.stringBuilderString(100000);
	}
	
	//concat方法连接
	private void concatString(int max) {
		String string = "";
		
		long start = System.currentTimeMillis();

		while (max!=0) {
			string = string.concat("a");
			max--;
		}
        long end = System.currentTimeMillis();

        System.out.println("长度："+string.length()+"---"+"string.concat(\"ss\")拼接；  cost=" + (end - start)+ " ms"); 
	}
	
	//加号拼接
	private  void addString(int max) {
		String str = "";

        long start = System.currentTimeMillis();
        
        while(max!=0){
            str = str + "a";
            max--;
        }

        long end = System.currentTimeMillis();

        System.out.println("长度："+str.length()+"---"+"加号拼接；  cost=" + (end - start) + " ms"); 
	}
	//StringBuilder拼接
	private  void stringBuilderString(int max) {
		StringBuilder sb = new StringBuilder();
		long start = System.currentTimeMillis();
		
		while(max!=0){
			sb.append("a");
			max--;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("长度："+sb.length()+"---"+"StringBuilder拼接；  cost=" + (end - start)*1000 + " ns"); 
	}

}
