package com.twf.class_14_4_0;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWindowListener extends WindowAdapter {

	private String result;
	public MyWindowListener() {
		super();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		JOptionPane.showConfirmDialog(null,Game.showResult() , "对战详情", JOptionPane.CANCEL_OPTION );

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
