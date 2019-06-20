package com.twf.class_04;

import java.awt.EventQueue;
/**
 * JFrame
 * @author TWF
 *@Date2019
 */
public class JFrameDemo1 {

	@SuppressWarnings("unused")
	private static AlgoFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(() ->{
			frame = new AlgoFrame("Welcome",500,600);
		});


	}

}
