package com.twf.class_14_4_0;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
		computerFirst = (int) ((Math.random() * 10) % 3 + 1);
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
