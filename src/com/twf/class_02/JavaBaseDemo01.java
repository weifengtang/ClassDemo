package com.twf.class_02;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 1、从控制台 输入 3个人成绩 double类型 ，保留三位小数点
 * 2、int型数据相乘，溢出问题
 * 3、判断奇 偶数 传入负数
 * @author TWF
 *
 */
public class JavaBaseDemo01 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		double d = 0;

		for (int i = 0; i < 3; i++) {
			String score = sc.next();
			d += Double.parseDouble(score);
		}
		// System.out.printf("%.3f",d);
		System.out.println(new DecimalFormat("#.000").format(d / 3));

		
		/*int型数据相乘，溢出问题
		 * Long max = 3 * 20 * 39 * 90; Long min = 20 * 39 * 90;
		 */
		Long max = 3 * 20 * 39 * 90L; 
		Long min = 20 * 39 * 90L;

		System.out.println(max / min);
		
	
		System.out.println(isOdd(4));
		System.out.println(isOdd(-3));
		name();

	}

	/**
	 * 判断奇 偶数 传入负数
	 * 
	 * @param i
	 * @return
	 */
	public static boolean isOdd(int i) {
		// return !(i%2==0);
		// return Math.abs(i)%2==1;
		// return (i&1)==1;//判断奇数
		return (i & 1) == 0;// 判断偶数
		// return i % 2 == 0;
	}
	
	public static void name() {
		System.out.println("返回值void时 return 可以省略");
		return;
	} 
}
