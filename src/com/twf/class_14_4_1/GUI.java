package com.twf.class_14_4_1;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI extends JFrame  {
	private User user;
	private Computer computer;
	private Game game;
	Object object; //事件

	public GUI() {
		super();
		init();
	}
	/**
	 * 初始化方法
	 */
	public void init() {
		// TODO用户登录选择用户名，及角色
		user = new User();
		computer = new Computer();
		game = new Game(user, computer);

		String iconString = "sources/m1.png";// 设置图标
		ImageIcon imageIcon = new ImageIcon(iconString);
		this.setIconImage(imageIcon.getImage());
		this.setTitle("猜拳游戏2222222222");
		this.setSize(500, 650);
		this.getContentPane().setBackground(Color.GRAY);// 设置背景颜色

		this.setResizable(false);// 不可拉伸窗口
		this.setLayout(null);// 绝对坐标布局
		this.setLocationByPlatform(true);// 位置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序结
		this.setVisible(true);
	}

}
