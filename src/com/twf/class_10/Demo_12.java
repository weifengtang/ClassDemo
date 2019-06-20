package com.twf.class_10;

import jdk.internal.dynalink.beans.StaticClass;

public class Demo_12 {
	static int i = 1000;
	public static void main(String[] args) {
		 
		/*
		 * //线程开启 一 new Thread(new Runnable() { public void run() { while (i>10) {
		 * System.out.println(i++); }
		 * 
		 * } }).start(); //线程开启 二 new Thread() { public void run() { while (i>1) {
		 * System.out.println("-------"+i--); } } }.start();
		 */
		try {
			doStuff(-1);
			doStuff(100);
		} catch (Exception e) {
			System.out.println("程序到这里结束");
		}

	}

	public static int doStuff(int _p) throws Exception {
		try {
			if (_p < 0) {
				throw new Exception("数据格式错误");
			} else {
				return _p;
			}
		} catch (Exception e) {
			throw e;
		} // return 返回结果正常，没有异常，所以之前异常被覆盖了
		finally { //finally块未完成正常
			//return 1;
		}

		// finally { }
	}

}


class A implements Runnable{
	@Override
	public void run() {
	}
	
}