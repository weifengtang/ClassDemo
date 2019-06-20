package com.twf.class_04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int canvasWidth;
	private int canvasHeight;
	
	public AlgoFrame(String title,int canvasWidth,int canvasHeight){
		super(title);
		
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
		
		//画布
		AlgoCanvas canvas = new AlgoCanvas();
		//canvas.setPreferredSize();
		setContentPane(canvas);
		pack();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	
	public AlgoFrame(String title) throws HeadlessException {
		this(title,1024,500);
	}



	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}
	
	
	//画布
	private class AlgoCanvas extends JPanel{
		
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			
			//画笔
			Graphics2D g2d = (Graphics2D) g;
			
			//抗锯齿
			RenderingHints hints = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);;
			
			g2d.addRenderingHints(hints);
			//具体绘制
			AlgoVisHelper.setStrokeWidth(g2d, 5);//设置画笔大小(线条宽度)
			AlgoVisHelper.setColor(g2d, Color.blue);
			AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2,200);//画实心圆
			AlgoVisHelper.setColor(g2d, Color.red);
			AlgoVisHelper.strokeCircle(g2d, canvasWidth/2, canvasHeight/2,200);//画空心圆
		}
		
		@Override
		public Dimension getPreferredSize(){
			return new Dimension(canvasWidth, canvasHeight);
		}
		
		
	}
	
	
}
