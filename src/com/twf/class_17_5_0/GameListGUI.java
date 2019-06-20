package com.twf.class_17_5_0;

import com.twf.class_17_5_0.ioUtils.IOUtils;
import com.twf.class_17_5_0.po.Rank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * @ClassName:GameListGUI
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/411:17
 * @Version:1.0
 **/
public class GameListGUI extends JFrame{
    JTable jTable;
    public GameListGUI() {
        super();
    }
    /**
     * 初始化方法
     */
    public void init(String userName) {

        String  list  = IOUtils.readDatas("D:/temp/sources/list.txt");

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
               new GuessGUI().init(userName);
            }
        });

        String  list2  = IOUtils.readDatas("D:/temp/sources/list.txt");
        String lists[] = list2.split(";");
        Object[][] data = getDatas("D:/temp/sources/list.txt");
        String[] tableHead = {"时间","玩家","得分"};
         jTable = new JTable(data,tableHead);

        JScrollPane scroll = new JScrollPane(jTable);
        scroll.setSize(500, 650);
        this.getContentPane().add(scroll);
        this.setResizable(false);// 不可拉伸窗口
        this.setLayout(null);// 绝对坐标布局
        this.setLocationByPlatform(true);// 位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭程序结
        this.setVisible(true);
    }

    public static void main(String[] args) {
       new GameListGUI().init("");
       // System.out.println(getList("D:/temp/sources/list.txt"));
    }
    //得到每一个元素 Rank{date='2019-06-04 06:49:31', userName='twf', Socre='3'}
    public static String getString(String str,String nameString){
        int start = str.indexOf(nameString+"='")+nameString.length()+2;
        int end = str.indexOf("'",start);
        return str.substring(start,end);
    }

    public static void sort( List<String> datas){
        int length =datas.size();
        for (int i = 0; i < length; i++) {//循环次数
            int key = Integer.parseInt(getString(datas.get(i),"Socre"));
            int position=i;
            for (int j = i + 1; j < length; j++) {//选出最小的值和位置
               int b = Integer.parseInt(getString(datas.get(j),"Socre"));
                if (b > key) {
                    key = b;
                    position = j;
                }
            }
            Collections.swap(datas, position, i);//交换位置

        }


    }
    //读取文件得到List
    public static List<String> getList(String  fileName){
        String  list  = IOUtils.readDatas(fileName);
        String strings[] = list.split(";");
        List<String> lists = Arrays.asList(strings);
        lists= new ArrayList<String>(lists);
        sort(lists);
        return  lists;
    }
    //生成列表数据
    public static Object[][] getDatas(String fileName){
        List<String> lists = getList(fileName);
        Object[][] datas = new Object[lists.size()][3];
        for (int i = 0;i<lists.size();i++){
            datas[i][0]=getString(lists.get(i),"date");;
            datas[i][1]=getString(lists.get(i),"userName");;
            datas[i][2]=getString(lists.get(i),"Socre");;
        }
        return datas;
    }

}
