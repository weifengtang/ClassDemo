package com.twf.class_18_6_0.classWork;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName:ClassDemo1
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/515:50
 * @Version:1.0
 * 模仿应用多线程倒计时效果
 **/
public class ClassDemo_01 extends JFrame {
        private JButton button;

        public void init() {
            this.setSize(550, 500);
            button = new JButton("5");
            button.setFont(new Font("", Font.BOLD, 208));
            this.add(button);
            // 启动
            ButtonAction t = new ButtonAction();
            t.start();
            this.setUndecorated(true);
            // 隐藏最大化最小化那一栏
            this.setAlwaysOnTop(true);
            // 窗口始终在最顶上
            this.setDefaultCloseOperation(0);
            // 防止按Alt+F4关闭  设置窗口出现的位置
            this.setLocationByPlatform(true);
            this.setLocation(410, 165);
            this.setLocationRelativeTo(null);
            // 设置居中

        }


class ButtonAction extends Thread {
    int num = 3;

    @Override
    public void run() {
        while (num != 0) {
            try {
                button.setText(num + "");
                sleep(1000);
                num--;
            } catch (Exception e) {

            }
        }
    }
}


public static void main(String[] args) {
    ClassDemo_01 frm = new ClassDemo_01();
    frm.init();
    frm.setVisible(true);
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
   // new GuessGameMainGUI().init("twf");
    frm.setVisible(false);
    System.exit(0);
        }

}