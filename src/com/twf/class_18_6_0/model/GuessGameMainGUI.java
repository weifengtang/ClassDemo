package com.twf.class_18_6_0.model;

import com.twf.class_18_6_0.gameUtils.GameRule;
import com.twf.class_18_6_0.gameUtils.SoundPlay;
import com.twf.class_18_6_0.IOUtils.IOUtils;
import com.twf.class_18_6_0.po.Computer;
import com.twf.class_18_6_0.po.Rank;
import com.twf.class_18_6_0.po.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class GuessGameMainGUI extends JFrame implements ActionListener {
	private User user;
	private Computer computer;
	private GameRule gameRule;
	private JLabel preLable; // 用户拳
	public static JLabel comLable; // 电脑出拳
	public static JLabel wLable; // 结果图标
	private JTextArea recLable;// 积分板
	//Object object; // 事件
	private JButton jLbl; // 用户选择 ：剪刀
	private JButton qLbl; // 石头
	private JButton bLbl; // 布
	JButton reset; // 重开
	Boolean flag = true;


	public GuessGameMainGUI() {
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
	public void init(String userName) {

		//播放音乐
		new Thread(()-> {
			new SoundPlay().play();
		}).start();


		// TODO用户登录选择用户名，及角色
		user = new User();
		computer = new Computer();
		gameRule = new GameRule(user, computer);
		menu(userName);
		String iconString = "sources/m1.png";// 设置图标
		ImageIcon imageIcon = new ImageIcon(iconString);
		this.setIconImage(imageIcon.getImage());
		this.setTitle("猜拳游戏-----"+userName);
		this.setSize(600, 750);
		this.getContentPane().setBackground(Color.GRAY);// 设置背景颜色

		JLabel m1Lable = new JLabel();
		this.setImg(this, m1Lable, "sources/m1.png", 27, 50, 85, 80);

		qLbl = new JButton();
		this.setButtonImg(this, qLbl, "sources/q.png", 40, 200, 50, 50);

		bLbl = new JButton();
		this.setButtonImg(this, bLbl, "sources/b.png", 40, 320, 50, 50);

		jLbl = new JButton();
		this.setButtonImg(this, jLbl, "sources/j.png", 40, 450, 50, 50);

		//用户出拳线程
		preLable = new JLabel();
		startThread(this);


		JLabel vs1Lable = new JLabel();
		this.setImg(this, vs1Lable, "sources/vs1.png", 250, 60, 70, 45);
		// 电脑出拳
		comLable = new JLabel();
		this.setImg(this, comLable, "sources/q.png", 360, 60, 50, 50);
		// 用户头像
		JLabel m2Lable = new JLabel();
		this.setImg(this, m2Lable, "sources/m2.png", 470, 50, 85, 80);

		JLabel vsLable = new JLabel();
		this.setImg(this, vsLable, "sources/a.gif", 180, 140, 330, 190);

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
				gameRule.reset();//清空积分
			}
		});


		this.setResizable(false);// 不可拉伸窗口
		this.setLayout(null);// 绝对坐标布局
		this.setLocationByPlatform(true);// 位置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序
		//窗口关闭事件
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//读取上一次成绩，
				String  old  = IOUtils.readDatas("D:/temp/sources/source.txt");
				if(gameRule.getCount()>0){
					//写入当前成绩
					IOUtils.writerDatas(gameRule.showResult(),"D:/temp/sources/source.txt",false);
					//写入排行榜
					IOUtils.writerDatas(new Rank(new Date(),userName,user.getSocre()).toString()+";","D:/temp/sources/list.txt",true);
				}
				new ResultGUI().init(old, gameRule.showResult());
                setVisible(false);


			}
		});//关闭监听事件
		this.setVisible(true);// 窗口是否可见
		regist();
	}

	//用户出拳动画：线程
	public void startThread(GuessGameMainGUI gui){
		new Thread(() -> {
			String imgs[] = {"sources/q.png","sources/j.png","sources/b.png"};
			while (flag) {
					try {

                        for (int i = 0; i < imgs.length; i++) {
							Thread.currentThread().sleep(600);
						    gui.setImg(gui, preLable, imgs[i], 150, 55, 50, 50);
                        }
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

			}
		}).start();



	}


	public void menu(String userName){
		JMenuBar mnuNotepad = new JMenuBar();
		this.setJMenuBar(mnuNotepad);

		JMenu mnuFile = new JMenu();
		JMenu mnuEdit = new JMenu();
		JMenu mnuFormat = new JMenu();
		JMenu mnuHelp = new JMenu();
		mnuFile.setText("玩家信息");
		mnuEdit.setText("游戏规则");

		mnuFormat.setText("设置");
		mnuHelp.setText("帮助");

		JMenuItem mnuNew = new JMenuItem();
		JMenuItem mnuOpen = new JMenuItem();
		JMenuItem mnuSave = new JMenuItem();
		JMenuItem mnuSaveAs = new JMenuItem();
		JMenuItem mnuExit = new JMenuItem();

		mnuNew.setText("新建游戏");
		mnuOpen.setText("重新开始");
		mnuSave.setText("暂停");
		mnuSaveAs.setText("排行榜");
		mnuSaveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameListGUI().init(userName);
				setVisible(false);
			}
		});
		mnuExit.setText("退出");

		mnuNotepad.add(mnuFile);
		mnuNotepad.add(mnuEdit);
		mnuNotepad.add(mnuFormat);
		mnuNotepad.add(mnuHelp);

		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.add(mnuSaveAs);
		mnuFile.add(mnuExit);
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
        flag = false;
		// 用户出拳
		user.punches(this, object);
		// 电脑出拳
		computer.punches(comLable);
		// 裁决
		gameRule.judge();
		recLable.setText(gameRule.showResult());

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

