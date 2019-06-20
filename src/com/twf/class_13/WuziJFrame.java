package com.twf.class_13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WuziJFrame extends JFrame {
	static Graphics g1;
	boolean flag = false;
	int x, y;

	public WuziJFrame() throws HeadlessException {
		this.setTitle("五子棋游戏");
		this.setSize(800, 600);
		// this.add(new MyPanel2(22, 22, 100, 102));
		MyPanel panel1 = new MyPanel();
		this.g1 = panel1.g2;
		this.add(panel1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		WuziJFrame jFrame = new WuziJFrame();
		jFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX() + "--" + e.getY());
			}
		});
	}

	class MyPanel extends JPanel {
		Graphics g2;

		@Override
		protected void paintComponent(Graphics g) {
			this.g2 = g;
			super.paintComponent(g);
			g.setColor(Color.red);

			int i = 20, j = 40;
			while (i <= 500) {
				while (j <= 700) {
					g.drawRect(j, i, 40, 40);
					j = j + 40;
				}
				j = 40;
				i = i + 40;
			}

		}

	}

}
