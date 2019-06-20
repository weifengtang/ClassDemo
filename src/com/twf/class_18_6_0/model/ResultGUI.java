package com.twf.class_18_6_0.model;

import javax.swing.*;
import java.awt.*;

public class ResultGUI extends JFrame  {

	public ResultGUI() {
		super();
	}
	/**
	 * 初始化方法
	 */
	public void init(String old,String now) {
		System.out.println("上一次成绩： "+old);
		System.out.println("本次成绩:"+now);
		// TODO用户登录选择用户名，及角色

		String iconString = "sources/m1.png";// 设置图标
		ImageIcon imageIcon = new ImageIcon(iconString);
		this.setIconImage(imageIcon.getImage());
		this.setTitle("显示结果");
		this.setSize(500, 650);
		this.getContentPane().setBackground(Color.GRAY);// 设置背景颜色

		this.setResizable(false);// 不可拉伸窗口
		this.setLayout(null);// 绝对坐标布局
		this.setLocationByPlatform(true);// 位置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序结
		this.setVisible(true);
	}

}
