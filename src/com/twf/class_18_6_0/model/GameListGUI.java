package com.twf.class_18_6_0.model;

import com.twf.class_18_6_0.IOUtils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName:GameListGUI
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/411:17
 * @Version:1.0
 *
 *
 * 排行榜
 **/
public class GameListGUI extends JFrame{
    private JTable jTable;
    private FileManager fileManager;
    public GameListGUI() {
        super();
    }
    /**
     * 初始化方法
     */
    public void init(String userName) {
        fileManager = new FileManager();

        String iconString = "sources/m1.png";// 设置图标
        ImageIcon imageIcon = new ImageIcon(iconString);
        this.setIconImage(imageIcon.getImage());
        this.setTitle("排行榜");
        this.setSize(500, 650);
        this.getContentPane().setBackground(Color.GRAY);// 设置背景颜色
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               setVisible(false);
               new GuessGameMainGUI().init(userName);
            }
        });

        //设置列表
        String pathName = "D:/temp/sources/list.txt";
        Object[][] datas = fileManager.getDatas(pathName);
        String[] tableHead = {"时间","玩家","得分"};
        jTable = new JTable(datas,tableHead);

        JScrollPane scroll = new JScrollPane(jTable);
        scroll.setSize(500, 650);
        this.getContentPane().add(scroll);
        this.setResizable(false);// 不可拉伸窗口
        this.setLayout(null);// 绝对坐标布局
        this.setLocationByPlatform(true);// 位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序结
        this.setVisible(true);
    }

   /* public static void main(String[] args) {
       new GameListGUI().init("");
       // System.out.println(getList("D:/temp/sources/list.txt"));
    }*/

}
