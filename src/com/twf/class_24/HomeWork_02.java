package com.twf.class_24;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @ClassName:HomeWork_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1622:41
 * @Version:1.0
 * 使用随机读取类RandomAccessFile类,可以随机的读取一个文件中
 * 指定位置的数据,例如,先在文件中 保存了以下的三个数据,
 * 再通过指定位置读取出来：
 * •zhangsan,30 •lisi,31 •wangwu,32
 **/
public class HomeWork_02 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile  =   new RandomAccessFile(new File("D:temp/data.txt"),"rw");

        System.out.println(randomAccessFile.length());

//        for (int i = 0; i < randomAccessFile.length(); i++){
////           char  a = (char) randomAccessFile.read();
//            int  a =  randomAccessFile.read();
//            System.out.print(a+",");
    // zhangsan,30
//122,104,97,110,103,115,97,110, 44,  51,48,  32,13,10;     ------》' ','\r' ,'\n' 各占一位
        //lisi,31
// 108,105,115,105,              44,  51,49,  32,13,10,
        //wangwu,32
// 119,97,110,103,119,117，      44,  51,50,  32,
//        }

        //randomAccessFile不能进行第二次读取操作
        byte b[] = new byte[14];
        int len=  0;
// 122,104,97,110,103,115,97,110,  44,  51,48,  32,;
// 13,10,108,105,115,105,  44,  51,49,   32,13,10,;
// 119,97,110,103,119,117,  44,  51,50,  32,13,10,;
        while ((len  = randomAccessFile.read(b))!=-1){ //重复读了几位
            for (int i = 0; i <b.length ; i++) {
                System.out.print(b[i]+",");
            }
            System.out.print(";");
        }
        System.out.println("");
        randomAccessFile.seek(14);//设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作
        //  12 13  14  为空 ------》' ','\r' ,'\n' 各占一位
        String data = randomAccessFile.readLine();
        System.out.println("data="+data);
        System.out.println((int)'n');
        System.out.println((int)'i');
        System.out.println((int)'u');

        System.out.println((int)',');
        System.out.println((int)' ');//32
        System.out.println((int)'\r');//13
        System.out.println((int)'\n');//10
        System.out.println((char)117);
    }
}
