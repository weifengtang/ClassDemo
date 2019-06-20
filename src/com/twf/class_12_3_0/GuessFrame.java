package com.twf.class_12_3_0;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuessFrame extends JFrame implements ActionListener {

	private JLabel preLable; // 用户拳
	private JLabel comLable; // 电脑出拳
	private JLabel wLable; // 结果图标
	private JLabel recLable;// 积分板

	private JButton jLbl; // 用户选择 ：剪刀
	private JButton qLbl; // 石头
	private JButton bLbl; // 布

	private int userFirst = 0; // 用户出拳
	private int computerFirst = 0;// 电脑出拳
	private int count = 0; // 对战次数
	private int userSocre = 0; // 用户得分
	private int comSocre = 0; // 用户得分

	public GuessFrame() {
		super();
		this.init();
		jLbl.addActionListener(this);
		qLbl.addActionListener(this);
		bLbl.addActionListener(this);
	}

	private void init() {
		String iconString = "sources/m1.png";// 设置图标
		ImageIcon imageIcon = new ImageIcon(iconString);
		this.setIconImage(imageIcon.getImage());
		this.setTitle("猜拳游戏");
		this.setSize(600, 600);
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
		recLable = new JLabel();
		this.setImg(this, recLable, "", 160, 400, 500, 200);

		this.setResizable(false);// 不可拉伸窗口
		this.setLayout(null);// 绝对坐标布局
		this.setLocationByPlatform(true);// 位置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序结

		this.setVisible(true);// 窗口是否可见
	}

	public static void main(String[] args) {
		new GuessFrame();
	}

	// 设置lable 图标
	private void setImg(JFrame jFrame, JLabel jLabel, String iconString, int x, int y, int h, int w) {
		ImageIcon imageIcon = new ImageIcon(iconString);
		jLabel.setIcon(imageIcon);
		jLabel.setBounds(x, y, h, w);
		jFrame.add(jLabel);
	}

	// 放置按钮 图标
	private void setButtonImg(JFrame jFrame, JButton jButton, String iconString, int x, int y, int h, int w) {
		jButton.setIcon(new ImageIcon(iconString));
		jButton.setBounds(x, y, h, w);
		this.add(jButton);
	}

	// 用户出拳 事件监听
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnObj = (JButton) e.getSource();
		ImageIcon imageIcon2 = null;
			if (btnObj == jLbl) {
				userFirst = 1;
				imageIcon2 = new ImageIcon("sources/j.png");
				preLable.setIcon(imageIcon2);
			}
			if (btnObj == qLbl) {
				userFirst = 2;
				imageIcon2 = new ImageIcon("sources/q.png");
				preLable.setIcon(imageIcon2);

			}
			if (btnObj == bLbl) {
				userFirst = 3;
				imageIcon2 = new ImageIcon("sources/b.png");
				preLable.setIcon(imageIcon2);
			}
			// 电脑出拳
			computerShowFirst();
			// 裁决
			judge();
			showResult();
		
	}

	// 电脑出拳
	// 电脑随机出拳
	private int computerShowFirst() {
		computerFirst = (int) ((Math.random() * 10) % 3 + 1);
		ImageIcon imageIcon2 = null;
		switch (computerFirst) {
		case 1:
			imageIcon2 = new ImageIcon("sources/j.png");
			comLable.setIcon(imageIcon2);
			break;
		case 2:
			imageIcon2 = new ImageIcon("sources/q.png");
			comLable.setIcon(imageIcon2);
			break;
		case 3:
			imageIcon2 = new ImageIcon("sources/b.png");
			comLable.setIcon(imageIcon2);
			break;
		}
		return computerFirst;
	}

	// 裁决猜拳结果
	public void judge() {
		ImageIcon imageIcon2 = null;
		if (userFirst == computerFirst) { // 1剪刀 2石头 3布
			imageIcon2 = new ImageIcon("sources/z.png");
			wLable.setIcon(imageIcon2);
		} else if ((userFirst == 1 && computerFirst == 3) || (userFirst == 2 && computerFirst == 1)
				|| (userFirst == 3 && computerFirst == 2)) {// 用户 1-3 2-1 3-2
			imageIcon2 = new ImageIcon("sources/h.png");
			wLable.setIcon(imageIcon2);
			userSocre++;
		} else {
			imageIcon2 = new ImageIcon("sources/w.png");
			wLable.setIcon(imageIcon2);
			comSocre++;
		}
		count++;
	}

	
	/**
	 * 计算结果
	 */
	public int callResult() {
		if (userSocre > comSocre) {
			return 0;
		} else if (userSocre < comSocre) {
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * 显示结果
	 */
	public void showResult() {

		int num = callResult();
		if (num == 0) {
			recLable.setText("\t对战次数："+count+"   "+"平局次数："+(count-userSocre-comSocre)+"  用户 " + userSocre + " 分      电脑：" + comSocre + "分  用户赢了");
		} else if (num == 1) {
			recLable.setText("\t对战次数："+count+"   "+"平局次数："+(count-userSocre-comSocre)+"  用户 " + userSocre + " 分      电脑：" + comSocre + "分  电脑赢了");
		} else {
			recLable.setText("\t对战次数："+count+"   "+"平局次数："+(count-userSocre-comSocre)+"  用户 " + userSocre + " 分      电脑：" + comSocre + "分  平局");
		}
	}
}
