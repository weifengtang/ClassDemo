package com.twf.class_17_5_0;

import com.twf.class_17_5_0.po.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName:LoginGUI
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/410:16
 * @Version:1.0
 **/
public class GameLogin extends JFrame{



    public GameLogin() {

    }
    public void init(){
        String iconString = "sources/m1.png";// 设置图标
        ImageIcon imageIcon = new ImageIcon(iconString);
        this.setIconImage(imageIcon.getImage());
        this.setTitle("游戏登录");
        this.setSize(300, 250);
        this.getContentPane().setBackground(Color.white);// 设置背景颜色

        JLabel jLabel1 = new JLabel("用户名：");
        JLabel jLabel2 = new JLabel("密码：");

        JTextField user_field = new JTextField();
        JPasswordField pwd_fied = new JPasswordField();

        JButton btn_Login = new JButton("登录");
        btn_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = user_field.getText();
                String pwd = pwd_fied.getText();
                if(User.login(user,pwd)>0){
                    new GuessGUI().init(user);
                    setVisible(false);
                }
            }
        });
        JButton btn_Cancel = new JButton("取消");

        JPanel jPanelInput = new JPanel();
        jPanelInput.setLayout(new GridLayout(2,2,1,1));
        jPanelInput.add(jLabel1);
        jPanelInput.add(user_field);
        jPanelInput.add(jLabel2);
        jPanelInput.add(pwd_fied);

        JPanel jPanelInput2 = new JPanel();
        jPanelInput2.setLayout(new FlowLayout());
        jPanelInput2.add(btn_Login);
        jPanelInput2.add(btn_Cancel);


        this.setResizable(false);// 不可拉伸窗口
        this.setLayout(new BorderLayout());// 绝对坐标布局
        this.add(jPanelInput,BorderLayout.CENTER);
        this.add(jPanelInput2,BorderLayout.SOUTH);

        this.setLocationByPlatform(true);// 位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序结
        this.setVisible(true);
    }


}
