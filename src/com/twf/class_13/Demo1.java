package com.twf.class_13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * 事件监听器类的编写要点 事件监听器类应该包括以下两部分内容： 
 * 1.在事件监听器类的声明中指定要实现的监听器接口名
 * 2.实现监听器接口中的事件处理方法，
 * 然后，在一个或多个组件上可以进行监听器类的实例的注册。
 * 如： 组 件 对 象 .addXxxListener( M y L i s t e n e r 对 象 ); 
 *@Classname:Demo1 
 *@author TWF
 *@Date:2019年5月29日下午4:58:25
 *@version 1.0
 */
public class Demo1 extends JFrame {

	public Demo1()  {
		super();
		this.setTitle("测试1");
		this.setSize(800, 600);
		this.setLayout(null);
		JButton jButton = new JButton();
		jButton.setText("点击");
		jButton.setBounds(200,100, 200, 50);
		jButton.addActionListener(new MyListener());
		
		this.add(jButton,"Center");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Demo1();
	}

}


class MyListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action occurred");
		System.out.println("Button’s label is:"+ e.getActionCommand());
		 
	
	}

}