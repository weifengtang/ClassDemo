package com.twf.class_18_6_0.po;

import javax.swing.*;
import java.util.Random;

/**
 * 电脑
 */
public class Computer {

	
	private String name = "【电脑】";//姓名
	private int socre = 0 ; // 得分
	private int computerFirst = 0;// 电脑出拳
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getComputerFirst() {
		return computerFirst;
	}

	public void setComputerFirst(int computerFirst) {
		this.computerFirst = computerFirst;
	}

	public int getSocre() {
		return socre;
	}

	public void setSocre(int socre) {
		this.socre = socre;
	}


	
	/**
	 * 计算机出拳：1、剪刀 2、石头 3、布
	 */
	public int punches(JLabel comLable){
		//computerFirst = (int) ((Math.random() * 10) % 3 + 1);
		int computerFirst = new Random().nextInt(3)+1; //伪随机的生成 int 值。0，1，2三个数
		switch (computerFirst) {
		case 1:
			comLable.setIcon(new ImageIcon("sources/j.png"));
			break;
		case 2:
			comLable.setIcon(new ImageIcon("sources/q.png"));
			break;
		case 3:
			comLable.setIcon(new ImageIcon("sources/b.png"));
			break;
		}
		return computerFirst;
	}
}
