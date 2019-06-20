package com.twf.class_15;
import static java.util.Arrays.toString;
public class Demo_13 {
	static void printArgs(Object... args) {
		System.out.println(args.toString());
		//toString(args); //与object中toString()冲突
		System.out.println();
	}

	public static void main(String[] args) {
		printArgs(1, 2, 3, 4, 5);
	}

}
