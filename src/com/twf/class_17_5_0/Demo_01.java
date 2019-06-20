package com.twf.class_17_5_0;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * @ClassName:Demo_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/48:27
 * @Version:1.0
 **/
public class Demo_01 {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        File file = new File("D://");
        String[] string = file.list();
        System.out.println(" 修改时间   \t\t 是否为目录 \t文件大小\t文件名");
        for (int i = 0; i <string.length; i++) {
            File file2 = new File(string[i]);
            String dir = "--";
            if(file2.isDirectory())//判断是否为目录
               dir ="<DIR>";
            long length=0;
            if(file2.isFile())
                length= file2.length();
            System.out.println(simpleDateFormat.format(file2.lastModified())+"\t\t"+dir+"\t\t\t   "+length+"\t\t"+file2.getName());
        }

    }
}
