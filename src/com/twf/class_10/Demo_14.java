package com.twf.class_10;

public class Demo_14 {

	public static void main(String[] args) {
		Person2 p = new Person2(16);
//		Person p = new Person(19);
		p.seeMovie();
	}

}

class Person2 {
	public Person2(int _age) {
		if (_age < 18) {
			throw new RuntimeException("年龄必须大于18岁。");
		}
	}

	public void seeMovie() {
		System.out.println("看限制级电影");
	}
}