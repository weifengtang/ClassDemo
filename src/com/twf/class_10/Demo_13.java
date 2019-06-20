package com.twf.class_10;

import java.util.Arrays;

public class Demo_13 {

	/**
	 * 英文排序：26个字母顺序
	 * 中文排序按 ASCII编码表
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = { "(Z)张三", "(L)李四", "(L)王五" }; // 排序,默认是升序
		System.out.println((int)'张'); 
		Arrays.sort(strs);
		int i = 0;
		for (String str : strs) {
			System.out.println((++i) + "、" + str);
		}
	}

}
