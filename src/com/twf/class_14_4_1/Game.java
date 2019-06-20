package com.twf.class_14_4_1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 游戏类
 * 
 * @Classname:Game
 * @author TWF
 * @Date:2019年5月30日上午9:58:05
 * @version 1.0
 */
public class Game {

	private static User user;
	private static Computer computer;
	private static int count = 0; // 对战次数

	public Game() {

	}

	public Game(User user, Computer computer) {
		super();
		this.user = user;
		this.computer = computer;
	}

	// 裁决猜拳结果
	public void judge() {
		
		int userFirst = user.getUserFirst();
		int comFirst = computer.getComputerFirst();
		if (userFirst == comFirst) { // 1剪刀 2石头 3布
			GuessGUI.wLable.setIcon(new ImageIcon("sources/z.png"));
		} else if ((userFirst == 1 && comFirst == 3)
				|| (userFirst == 2 && comFirst == 1)
				|| (userFirst == 3 && comFirst == 2)) {// 用户 1-3 2-1 3-2
			GuessGUI.wLable.setIcon(new ImageIcon("sources/h.png"));
			user.setSocre(user.getSocre() + 1);
		} else {
			GuessGUI.wLable.setIcon(new ImageIcon("sources/w.png"));
			computer.setSocre(computer.getSocre() + 1);
		}
		count++;
	}

	/**
	 * 显示结果
	 */
	public   String  showResult() {

		StringBuilder sb = new StringBuilder();
		sb.append("\t--------对战结果-------------\r\n");
		sb.append("\t用户选择-对战次数 ： " + count+"\n");
		sb.append("\t" + user.getName() + " VS " + computer.getName()+"\n");
		sb.append("\t得分：用户 " + user.getSocre() + "分      电脑：" + computer.getSocre() + "分"+"\n");
		int num = callResult(user.getSocre(),computer.getSocre());
		if (num == 0) {
			sb.append("\t用户赢了 ");
		} else if (num == 1) {
			sb.append("\t电脑赢了 ");
		} else {
			sb.append("\t平局 "+(count-user.getSocre()-computer.getSocre())+"\n");
			sb.append("\t平局  ");
		}
		return sb.toString();
	}

	/**
	 * 计算结果
	 */
	public  int callResult(int userScore , int comScore) {
		System.out.println(userScore+"---------"+comScore);
		if (userScore > comScore) {//用户赢
			return 0;
		} else if (userScore < comScore) {
			return 1;
		} else{
			return 2;
		}
		
	}

	public void reset() {
		user.setSocre(0);
		computer.setSocre(0);
		count=0;
	}

}
