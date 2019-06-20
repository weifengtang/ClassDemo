package com.twf.class_03;
/**
 */
public class Demo {
	public static void main(String[] args) {
		getCt(5);
	}

	public static void getCt(int c) {
		int RangeofC = (int) Math.floor(c / 5);
		System.out.println(RangeofC);
		switch (RangeofC) {
			case 1:
				System.out.println("10 C ");
				break;
			case 2:
				System.out.println("出去!");
				break;
			case 3:
				System.out.println("出去!");
				break;
			case 4:
				System.out.println("出去!");
				break;
			case 5:
				System.out.println("有点热!");
				break;
			case 6:
				System.out.println("有点热!");
				break;
			case 7:
				System.out.println("开空调！");
				break;
			case 8:
				System.out.println("开空调！");
				break;
			default:
				System.out.println("有问题！");
				break;
		}
	}
	//复制数组
	public static void copyArry(int[] oldStr, int start, int[] narr, int destart,int length) {
		if (oldStr == null || oldStr.length == 0) {
			return;
		}
		for (int j = start; j < start + length; j++) {
			if (j < oldStr.length && destart < narr.length) {
				narr[destart++] = oldStr[j];
			} else {
				break;
			}
		}
	}

}
