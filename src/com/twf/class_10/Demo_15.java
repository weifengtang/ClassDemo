package com.twf.class_10;

import java.io.IOException;

public class Demo_15 {
	public static void main(String[] args) {
		try {
			DBBase base = new MySQLDB();
			base.hashCode();
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	class DBBase {// 父类 // 父类抛出IOException
		public DBBase() throws IOException {
			throw new IOException();
		}
	}

class MySQLDB extends DBBase {// 子类 // 子类抛出Exception异常
	public MySQLDB() throws Exception {
		super();
		System.out.println("子类异常s");
	}
}
