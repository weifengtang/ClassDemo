package com.twf.class_18_6_0.po;

import com.twf.class_18_6_0.model.GuessGameMainGUI;

import javax.swing.*;
import java.io.Serializable;

/**
 * 用户
 */
public class User implements Serializable {

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

	public int punches(GuessGameMainGUI guessGameMainGUI, Object btnObj) {
		//btnObj = (JButton)btnObj;
		if (btnObj == guessGameMainGUI.getjLbl()) {
			userFirst = 1;
			guessGameMainGUI.getPreLable().setIcon(new ImageIcon("sources/j.png"));//替换
		}
		if (btnObj == guessGameMainGUI.getqLbl()) {
			userFirst = 2;
			guessGameMainGUI.getPreLable().setIcon(new ImageIcon("sources/q.png"));
		}
		if (btnObj == guessGameMainGUI.getbLbl()) {
			userFirst = 3;
			guessGameMainGUI.getPreLable().setIcon(new ImageIcon("sources/b.png"));
		}
		return userFirst;
	}

}
