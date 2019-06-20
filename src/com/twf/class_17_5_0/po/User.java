package com.twf.class_17_5_0.po;

import com.twf.class_17_5_0.GuessGUI;

import javax.swing.*;

public class User {

	private String name = "【唐伟锋】";// 用户姓名
	private int userFirst = 0; // 用户出拳
	private int userSocre = 0; // 得分
	
	public static int login(String user,String pwd){
		if("twf".equals(user)&&"twf".equals(pwd))
			return 1;
		return -1;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserFirst() {
		return userFirst;
	}

	public void setUserFirst(int userFirst) {
		this.userFirst = userFirst;
	}

	public int getSocre() {
		return userSocre;
	}

	public void setSocre(int socre) {
		this.userSocre = socre;
	}

	/**
	 * 用户出拳：1、剪刀 2、石头 3、布
	 */

	public int punches(GuessGUI guessGUI, Object btnObj) {
		//btnObj = (JButton)btnObj;
		if (btnObj == guessGUI.getjLbl()) {
			userFirst = 1;
			guessGUI.getPreLable().setIcon(new ImageIcon("sources/j.png"));//替换
		}
		if (btnObj == guessGUI.getqLbl()) {
			userFirst = 2;
			guessGUI.getPreLable().setIcon(new ImageIcon("sources/q.png"));
		}
		if (btnObj == guessGUI.getbLbl()) {
			userFirst = 3;
			guessGUI.getPreLable().setIcon(new ImageIcon("sources/b.png"));
		}
		return userFirst;
	}

}
