package com.twf.class_14_4_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GuessGUI extends JFrame implements ActionListener {
	private User user;
	private Computer computer;
	private Game game;
	private JLabel preLable; // 用户拳
	 static JLabel comLable; // 电脑出拳
	 static JLabel wLable; // 结果图标
	private JTextArea recLable;// 积分板
	Object object; // 事件
	private JButton jLbl; // 用户选择 ：剪刀
	private JButton qLbl; // 石头
	private JButton bLbl; // 布
	JButton reset; // 重开

	public GuessGUI() {
		super();
	}

	/**
	 * 注册事件
	 */
	private void regist() {
		jLbl.addActionListener(this);
		qLbl.addActionListener(this);
		bLbl.addActionListener(this);
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
		this.setTitle("猜拳游戏");
		this.setSize(600, 650);
		this.getContentPane().setBackground(Color.GRAY);// 设置背景颜色

		JLabel m1Lable = new JLabel();
		this.setImg(this, m1Lable, "sources/m1.png", 27, 50, 85, 80);

		qLbl = new JButton();
		this.setButtonImg(this, qLbl, "sources/q.png", 40, 200, 50, 50);

		bLbl = new JButton();
		this.setButtonImg(this, bLbl, "sources/b.png", 40, 320, 50, 50);

		jLbl = new JButton();
		this.setButtonImg(this, jLbl, "sources/j.png", 40, 450, 50, 50);
	
	

		preLable = new JLabel();
		this.setImg(this, preLable, "sources/q.png", 150, 55, 50, 50);

		JLabel vs1Lable = new JLabel();
		this.setImg(this, vs1Lable, "sources/vs1.png", 250, 60, 70, 45);
		// 电脑出拳
		comLable = new JLabel();
		this.setImg(this, comLable, "sources/q.png", 360, 60, 50, 50);
		// 用户头像
		JLabel m2Lable = new JLabel();
		this.setImg(this, m2Lable, "sources/m2.png", 470, 50, 85, 80);

		JLabel vsLable = new JLabel();
		this.setImg(this, vsLable, "sources/vs.png", 180, 140, 330, 190);

		wLable = new JLabel();
		this.setImg(this, wLable, "", 180, 320, 330, 190);
		
		// 积分板
		recLable = new JTextArea();
		//this.setImg(this, recLable, "", );
		recLable.setBounds(200, 500, 300, 100);
		this.add(recLable);
		
		reset = new JButton();
		reset.setText("重新开始");
		this.setButtonImg(this, reset, "", 40, 550, 100, 50);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recLable.setText("\t--------重新开始--------");
				game.reset();//清空积分
			}
		});
		
		
		//this.setResizable(false);// 不可拉伸窗口
		this.setLayout(null);// 绝对坐标布局
		this.setLocationByPlatform(true);// 位置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				GUI gui = new GUI();
				gui.setVisible(true);
			}
		});//关闭监听事件
		this.setVisible(true);// 窗口是否可见
		regist();
	}

	// 设置lable 图标
	private void setImg(JFrame jFrame, JLabel jLabel, String iconString, int x, int y, int h, int w) {
		ImageIcon imageIcon = new ImageIcon(iconString);
		jLabel.setIcon(imageIcon);
		jLabel.setBounds(x, y, h, w);
		jFrame.add(jLabel);
	}

	// 放置按钮 图标
	public void setButtonImg(JFrame jFrame, JButton jButton, String iconString, int x, int y, int h, int w) {
		jButton.setIcon(new ImageIcon(iconString));
		jButton.setBounds(x, y, h, w);
		this.add(jButton);
	}

	// 事件处理方法
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		// 用户出拳
		user.punches(this, object);
		// 电脑出拳
		computer.punches(comLable);
		// 裁决
		game.judge();
		recLable.setText(game.showResult());
	}

	public JLabel getPreLable() {
		return preLable;
	}

	public JButton getjLbl() {
		return jLbl;
	}

	public JButton getqLbl() {
		return qLbl;
	}

	public JButton getbLbl() {
		return bLbl;
	}

}
