package com.twf.class_12_3_0;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JpgFrame extends JFrame implements ActionListener {
	int count = 1;
	private CardLayout card;
	
	private JLabel jLabel;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;

	public JpgFrame() {
		this.setTitle("翻牌游戏");
		this.setSize(600, 400);
		this.getContentPane().setBackground(Color.gray);// 设置背景颜色
		this.setLayout(new FlowLayout());// 绝对坐标布局

		jButton1 = new JButton("第一张");

		jButton2 = new JButton("最后一张");

		jButton3 = new JButton("上一张");
		jButton4 = new JButton("下一张");
		//增加事件
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jButton3.addActionListener(this);
		jButton4.addActionListener(this);
		
		//图片
		jLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon("sources/1.jpg");
		jLabel.setIcon(imageIcon);
		jLabel.setBounds(100, 100, 200,200);
	
		this.add(jButton1);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jLabel);
		
		this.setResizable(false);// 不可拉伸窗口
		this.setLocationByPlatform(true);// 位置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序结

		this.setVisible(true);// 窗口是否可见
	}

	public static void main(String[] args) {
		new JpgFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		ImageIcon imageIcon = null;
		if(count<=0 ||count>5) {
			count=1;
		}
		if(jButton==jButton1) {
			imageIcon = new ImageIcon("sources/"+1+".jpg");
			jLabel.setIcon(imageIcon);
		}else if(jButton==jButton2) {
			imageIcon = new ImageIcon("sources/"+5+".jpg");
			jLabel.setIcon(imageIcon);
		}else if(jButton==jButton3) {
			imageIcon = new ImageIcon("sources/"+(count--)+".jpg");
			jLabel.setIcon(imageIcon);
		}else if(jButton==jButton4) {
			imageIcon = new ImageIcon("sources/"+(count++)+".jpg");
			jLabel.setIcon(imageIcon);
		}
		
	}

}
