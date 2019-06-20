package com.twf.class_01;


import java.util.Random;
import java.util.Scanner;

/**
 * 猜拳游戏：
 *
 * 版本1 单类实现
 *
 * @author TWF
 * @Date2019年5月13日
 */
public class GuessGame {

    private static String computer = "电脑";// 表示电脑
    private static String person = "";// 表示用户

    private static int computerScore = 0;// 表示电脑的成绩
    private static int userScore = 0;// 表示用户的成绩
    private static int geamCount = 0;// 表示比赛次数
    private static Scanner input = null;

    public static void main(String[] args) {
        System.out.println("------------------欢迎进入游戏世界------------------\n");
        System.out.println("\n\t\t*********************");
        System.out.println("\t\t**   猜拳，开始         **");
        System.out.println("\t\t*********************\n\n");

        System.out.println("出拳规则：0.剪刀  1.石头  2.布");
        System.out.println("请选择角色（1：张无忌   2：乔峰   3：令狐冲  ）：");
        input = new Scanner(System.in);
        selectRole();// 用户选择角色

        System.out.println("要开始吗？（y/n）");
        String start = input.next();
        Integer userSelect;
        Integer computerSelecet;
        while (start.equals("y")) {
            // 用户出拳
            userSelect = userSelecet();
            // 电脑随机出拳
            computerSelecet = computerSelecet();

            // 比较结果
            if (userSelect - computerSelecet == 0) {// 0-0 1-1 2-2
                System.out.println("结果:和局,真衰！嘿嘿,等着瞧吧 !\n");
            } else if (userSelect - computerSelecet > 0) {// 1-0 2-0 2-1
                userScore++;
                System.out.println("结果： 恭喜，" + person + "  你赢了！");
            } else {// 0-1 0-2 1-2
                computerScore++;
                System.out.println("结果说:^_^," + person + "你输了，真笨!\n");
            }
            geamCount++;
            System.out.println("要开始吗？（y/n）");
            start = input.next();
        }

        show();

    }

    /**
     * 显示结果
     */
    public static void show() {
        System.out.println("------------------------------");
        System.out.println(person + " VS " + computer);
        System.out.println("对战次数 ： " + geamCount);
        if (userScore - computerScore > 0) {
            System.out.println("结果：恭喜恭喜！");
        } else if (userScore - computerScore == 0) {
            System.out.println("结果：打成平手，下次再和你一分高下！");
        } else {
            System.out.println("结果：呵呵，笨笨，下次加油啊！");
        }
        System.out.println("------------------------------");
    }

    /**
     * 电脑出拳
     *
     * @return
     */
    private static int computerSelecet() {
        int i = new Random().nextInt(3);
        switch (i) {
            case 0:
                System.out.println("电脑出拳： 剪刀");
                break;
            case 1:
                System.out.println("电脑出拳： 石头");
                break;
            case 2:
                System.out.println("电脑出拳： 布");
                break;
        }
        return i;
    }

    /**
     * 用户选择 出拳
     *
     * @param
     * @return
     */
    private static int userSelecet() {
        System.out.println("用户请出拳：0.剪刀 1.石头2. 布（请输入相应的数字）");
        String  i  = input.next() ;
        switch (i) {
            case "0":
                System.out.println("你出拳： 剪刀");
                break;
            case "1":
                System.out.println("你出拳： 石头");
                break;
            case "2":
                System.out.println("你出拳： 布");
                break;
            default:
                return  userSelecet();
        }
        return  Integer.parseInt(i);
    }

    /**
     * 用户选择角色：默认角色为唐伟锋
     *
     * @param
     */
    private static int  selectRole() {

        String  i  = input.next() ;
        switch (i) {
            case "1":
                person = "张无忌";
                break;
            case "2":
                person = "乔峰";
                break;
            case "3":
                person = "令狐冲";
                break;
            default:
                System.out.println("请输入1-3之间数字：");
                return selectRole();
        }
        return  Integer.parseInt(i);
    }

}
