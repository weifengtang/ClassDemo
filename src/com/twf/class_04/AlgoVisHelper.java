package com.twf.class_04;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * 工具类
 * @author TWF
 *
 */
public class AlgoVisHelper {

	
	private AlgoVisHelper() {}

	
	//设置画笔大小(线条宽度)
	public static void  setStrokeWidth(Graphics2D g2d,int strokeWidth) {
		g2d.setStroke(new BasicStroke(strokeWidth,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
	}
	
	//绘制空心圆
	public static void strokeCircle(Graphics2D g2d,int x,int y,int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,x-r,2*r,2*r);
		g2d.draw(circle);
	}
	//绘制实心圆
	public static void fillCircle(Graphics2D g2d,int x,int y,int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,x-r,2*r,2*r);
		g2d.fill(circle);
	}
	//设置画笔颜色
	public static void setColor(Graphics2D g2d,Color color) {
		g2d.setColor(color);
	}
	
	
}
