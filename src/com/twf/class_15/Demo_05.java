package com.twf.class_15;

import java.io.Serializable;
import java.util.Arrays;
import java.util.zip.ZipEntry;

/**
 * 
 * @Classname:Demo_05
 * @author TWF
 * @Date:2019年5月31日下午2:19:26
 * @version 1.0
 */
public class Demo_05 {

	//instanceof类型比较
	public static void main(String[] args) {

		Object hello = "hello";
		System.out.println(">>1:" + (hello instanceof Object)); //true
		System.out.println(">>2:" + (hello instanceof String));//true
		//Math math = (Math) hello;//java.lang.ClassCastException
		//System.out.println(">>3:" + (math instanceof Math));
		System.out.println(">>4:" + (hello instanceof Comparable));//true

		System.out.println(">>5:" + (null instanceof Object));//false null不属于任何类型，
		System.out.println(">>6:" + ("" instanceof Object));//true
		System.out.println(">>7:" + (null instanceof Arrays));//false
		
		System.out.println(">>8:" + (hello instanceof Serializable));//true

	}

}
